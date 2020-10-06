import java.util.Iterator;

public class LoanIterator implements Iterator<LoanPayment> {
	/**
	 * The suffering  controls if you really want the loan to be above
	 * zero for some reason at the end. Every other calculator is fine
	 * with it being at zero so I don't know why the textbook isn't.
	 */
	private static final boolean suffering = true;

	private final Loan loan;
	private int remainingMonths;
	private double remainingPrincipal;


	protected LoanIterator(Loan loan) {
		this.loan = loan;
		this.remainingMonths = loan.months;
		this.remainingPrincipal = loan.principal;
	}

	@Override
	public boolean hasNext() {
		return this.remainingMonths > 0;
	}

	private double calcPrincipalPaid(double interestPaid) {
		double principalPaid = this.loan.monthlyPayment - interestPaid;
		if (LoanIterator.suffering && remainingMonths == 0) {
			principalPaid -= 0.01;
		}
		return principalPaid;
	}

	@Override
	public LoanPayment next() {
		this.remainingMonths--;
		 // freeze all values here and close over them
		final int paymentNumber = this.loan.months - this.remainingMonths;
		final int remainingMonths = this.remainingMonths;

		final double interestPaid = this.loan.monthlyRate * this.remainingPrincipal;
		final double principalPaid = calcPrincipalPaid(interestPaid);

		final double totalPaid = paymentNumber * this.loan.monthlyPayment;

		this.remainingPrincipal -= principalPaid;

		final double remainingPrincipal = this.remainingPrincipal;
		final double totalRemaining = this.loan.totalPaymentNeeded - totalPaid;

		return new LoanPayment() {
			public int paymentNumber() { return paymentNumber; }
			public int paymentsRemaining() { return remainingMonths; }

			public double interestPaid() { return interestPaid; }
			public double principalPaid() { return principalPaid; }

			public double totalPaid() { return totalPaid; }
			public double remainingPrincipal() { return remainingPrincipal; }
			public double totalRemaining() { return totalRemaining; }
		};
	}
}
