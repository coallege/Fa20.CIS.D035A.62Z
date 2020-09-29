import java.util.Scanner;
import static java.lang.System.out;

public class ComputeLoan {
   private static final Scanner sc = new Scanner(System.in);
   public static void main(String[] dummy) {
      double loanAmount;
      int yearsLoanTime;
      double yearlyInterestRate;

      try {
         out.print("Loan amount: ");
         loanAmount = sc.nextDouble();
         out.print("Number of Years: ");
         yearsLoanTime = sc.nextShort();
         out.print("Annual Interest Rate: ");
         yearlyInterestRate = sc.nextDouble() / 100; // because it's a percent
      } catch (Exception e) {
         System.out.println("\nInterrupt. Exiting...");
         return;
      } finally {
         sc.close();
      }

      var monthsLoanTime = yearsLoanTime * 12;
      var monthlyInterestRate = yearlyInterestRate / 12;

      // test it out
      var thisloan = new Loan(loanAmount, monthlyInterestRate, monthsLoanTime);
      out.print(""
         + thisloan.monthlyPayment  + "\n"
         + "------------------------ \n"
         + thisloan.principal     + "\n"
         + thisloan.totalInterestNeeded + "\n"
      );

      for (var payment : thisloan) {
         out.printf("%s %s %s\n", payment.paymentNumber(), payment.interestPaid(), payment.principalPaid());
      }
   }
}
