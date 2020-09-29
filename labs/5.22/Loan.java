import java.util.Iterator;

class Loan implements Iterable<LoanPayment> {
   public final double principal;
   public final double monthlyRate;
   public final int months;

   public final double monthlyPayment;
   public final double totalInterestNeeded;
   public final double totalPaymentNeeded;

   public Loan(double principal, double monthlyRate, int months) {
      this.principal = principal;
      this.monthlyRate = monthlyRate;
      this.months = months;
      // calculate the monthly payment
      var q = Math.pow(1 + monthlyRate, months);
      this.monthlyPayment = (
         (principal * monthlyRate * q)
         /
         (q - 1)
      );

      this.totalPaymentNeeded = this.monthlyPayment * months;
      this.totalInterestNeeded = this.totalPaymentNeeded - principal;
   }

   @Override
   public Iterator<LoanPayment> iterator() {
      return new LoanIterator(this);
   }
}
