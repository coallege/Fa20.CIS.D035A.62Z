import java.util.Scanner;

public class ComputeLoan {
   public static void main(String[] dummy) {
      double loanAmount = intPrompt("Loan Amount: ");
      var yearsLoanTime = intPrompt("Number of Years: ");
      var yearlyInterestRate = intPrompt("Annual Interest Rate: ");
      sc.close();

      var monthsLoanTime = yearsLoanTime * 12;
      var monthlyInterestRate = yearlyInterestRate / 12;

   }

   private static Scanner sc = new Scanner(System.in);

   private static int intPrompt(String prompt) {
      System.out.print(prompt);
      return ComputeLoan.sc.nextInt();
   }
}
