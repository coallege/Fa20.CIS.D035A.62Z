class SavingsAccount {
	static double annualInterestRate;
	static void modifyInterestRate(final double rate) {
		annualInterestRate = rate;
	}

	static double getMonthlyInterest() {
		return annualInterestRate / 12;
	}

	/**
	 * The spec is conflicting.
	 * I am unable to do part 2 without making this a protected variable.
	 */
	protected double savingsBalance;
	protected String name = "SavingsAccount";

	SavingsAccount(final double bal) {
		if (bal < 0) {
			throw new RuntimeException(
				"The initial balance of a savings account should not be less than zero!"
			);
		}
		savingsBalance = bal;
	}

	SavingsAccount(final String nam, final double bal) {
		this(bal);
		name = nam;
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

	static String fmt(double d) {
		return String.format("%.2f", d);
	}

	@Override
	public String toString() {
		return (""
			+ name + " {\n"
			+ "   savingsBalance = " + fmt(savingsBalance) + ";\n"
			+ "}\n"
		);
	}
}
