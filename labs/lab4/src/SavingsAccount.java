class SavingsAccount {
	static double annualInterestRate;
	static void modifyInterestRate(final double rate) {
		annualInterestRate = rate;
	}

	static double getMonthlyInterest() {
		return annualInterestRate / 12;
	}

	private String name = "SavingsAccount";
	private double savingsBalance;

	SavingsAccount(String nam, double bal) {
		name = nam;
		savingsBalance = bal;
	}

	SavingsAccount(double bal) {
		savingsBalance = bal;
	}

	/**
	 * Unlike what the method name suggests,
	 * this method does not actually return anything.
	 * Rather, it mutates savingsBalance.
	 *
	 * Let's hear it for method names that sound like
	 * they should be pure functions but actually cause mutation.
	 */
	void calculateMonthlyInterest() {
		savingsBalance *= (1 + getMonthlyInterest());
	}

	String balAsFixedPrec2() {
		return String.format("%.2f", savingsBalance);
	}

	@Override
	public String toString() {
		return (""
			+ name + " {\n"
			+ "   savingsBalance = " + balAsFixedPrec2() + ";\n"
			+ "}\n"
		);
	}
}
