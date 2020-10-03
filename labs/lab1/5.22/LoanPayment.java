public interface LoanPayment {
   int paymentNumber();
   int paymentsRemaining();

   double interestPaid();

   double principalPaid();
   double remainingPrincipal();

   double totalPaid();
   double totalRemaining();
}
