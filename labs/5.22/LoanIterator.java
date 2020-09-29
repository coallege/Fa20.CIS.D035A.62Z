import java.util.Iterator;

public class LoanIterator implements Iterator<LoanPayment> {
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
      // TODO: THIS IS PROBABLY OFF BY ONE BUT I DON't CARE AEHAHAHA
      return this.remainingMonths > 0;
   }

   @Override
   public LoanPayment next() {
      this.remainingMonths--;
       // freeze all values here and close over them
      final int paymentNumber = this.loan.months - this.remainingMonths;
      final int remainingMonths = this.remainingMonths;
      final double interestPaid = this.loan.monthlyRate * this.remainingPrincipal;
      final double principalPaid = this.loan.monthlyPayment - interestPaid;
      final double totalPaid = paymentNumber * this.loan.monthlyPayment;
      final double remainingPrincipal = this.remainingPrincipal;
      final double totalRemaining = this.loan.totalPaymentNeeded - totalPaid;

      this.remainingPrincipal -= principalPaid;

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
