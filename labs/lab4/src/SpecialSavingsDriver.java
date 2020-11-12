public class SpecialSavingsDriver {
	public static void main(String[] args) {
		var saver1 = new SpecialSavings("Special saver1", 2000.00);
		var saver2 = new SpecialSavings("Special saver2", 3000.00);

		System.out.println("Initial:");
		System.out.print(saver1 + "" + saver2);

		System.out.println("Month 1:");
		saver1.deposit(11000); // have saver1 deposit 11k so that they get 10% interest
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.print(saver1 + "" + saver2);

		System.out.println("Month 2:");
		saver1.withdraw(11000); // then remove it before the next interest cycle
		saver2.deposit(7000);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.print(saver1 + "" + saver2);
	}
}
