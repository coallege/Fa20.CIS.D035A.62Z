import java.util.Iterator;
import java.util.Scanner;
import static java.lang.System.out;

abstract class LoanPayment {
   public short paymentNumber;
   public short paymentsRemaining;

   public double interestPaid;
   public double principalPaid;

   public double totalPaid;
   public double remainingBalance;
}

abstract class Loan implements Iterable<LoanPayment> {
   public final double principal;
   public final double monthlyRate;
   public final short months;


   public Loan(double principal, double monthlyRate, short months) {
      this.principal = principal;
      this.monthlyRate = monthlyRate;
      this.months = months;
   }

   @Override
   Iterator<LoanPayment> iterator() {
      return new Iterator<LoanPayment>(){
         
      };
   }
}

public class ComputeLoan {
   private static final Scanner sc = new Scanner(System.in);

   public static void main(String[] dummy) {
      out.print("Loan amount: ");
      var loanAmount = sc.nextDouble();
      var yearsLoanTime = sc.nextShort();
      var yearlyInterestRate = sc.nextDouble();
      sc.close();

      var monthsLoanTime = yearsLoanTime * 12;
      var monthlyInterestRate = yearlyInterestRate / 12;

   }
}
