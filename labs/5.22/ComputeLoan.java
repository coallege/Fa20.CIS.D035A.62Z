import java.util.Scanner;
import static java.lang.System.out;

public class ComputeLoan {
   private static final Scanner sc = new Scanner(System.in);

   /** clears the terminal */
   static void clear() {
      System.out.print("\033[3J\033[H\033[2J");
   }
   public static void main(String[] dummy) {
      clear();
      out.println(""
         + "ComputeLoan.java\n"
         + "Author: Cole Gannon\n"
      );

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
         out.println("\nInterrupt. Exiting...");
         return;
      } finally {
         sc.close();
      }

      var monthsLoanTime = yearsLoanTime * 12;
      var monthlyInterestRate = yearlyInterestRate / 12;

      var loan = new Loan(loanAmount, monthlyInterestRate, monthsLoanTime);

      out.printf("\nMonthly Payment: %.2f\n", loan.monthlyPayment);
      out.printf("Total Payment: %.2f\n\n", loan.totalPaymentNeeded);

      out.println("\nPayment#     Interest     Principal     Balance");
      for (var payment : loan) {
         out.printf("%-12d %-12.2f %-13.2f %-12.2f\n"
            , payment.paymentNumber()
            , payment.interestPaid()
            , payment.principalPaid()
            , payment.remainingPrincipal()
         );
      }
   }
}
