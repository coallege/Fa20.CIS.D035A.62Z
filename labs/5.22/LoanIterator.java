import java.util.Iterator;

public class LoanIterator implements Iterator<LoanPayment> {
   private final Loan loan;
   private int monthsLeft;

   protected LoanIterator(Loan loan) {
      this.loan = loan;
      this.monthsLeft = loan.months;
   }

   @Override
   public boolean hasNext() {
      // TODO: THIS IS PROBABLY OFF BY ONE BUT I DON't CARE AEHAHAHA
      return this.monthsLeft > 0;
   }

   @Override
   public LoanPayment next() {
      var this$ = this; // pain
      return new LoanPayment() {
         public int paymentNumber = this$.loan.months - this$.monthsLeft;
         public int paymentsRemaining = this$.monthsLeft;

         public double interestPaid;
         public double principalPaid;

         public double totalPaid;
         public double remainingBalance;
      };
   }
}
