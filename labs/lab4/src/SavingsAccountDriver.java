public class SavingsAccountDriver {
	public static void main(String[] e) {
		var saver1 = new SavingsAccount("saver1", 2000.00);
		var saver2 = new SavingsAccount("saver2", 3000.00);

		SavingsAccount.modifyInterestRate(0.04);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

		System.out.print(saver1 + "" + saver2);

		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

		System.out.print(saver1 + "" + saver2);
	}
}
