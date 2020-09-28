import java.util.Iterator;

class Loan implements Iterable<LoanPayment> {
   public final double principal;
   public final double monthlyRate;
   public final int months;

   public final double monthlyPayment;
   public final double totalInterest;
   public final double totalPayment;

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

      this.totalPayment = this.monthlyPayment * months;
      this.totalInterest = this.totalPayment - principal;
   }

   @Override
   public Iterator<LoanPayment> iterator() {
      return new LoanIterator(this);
   }
}
