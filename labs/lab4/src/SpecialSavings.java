class SpecialSavings extends SavingsAccount {
	SpecialSavings(final double bal) {
		super(bal);
	}

	SpecialSavings(final String name, final double bal) {
		super(name, bal);
	}

	void deposit(final double amt) {
		if (amt < 0) {
			throw new RuntimeException("You can't deposit a negative amount!");
		}
		savingsBalance += amt;
	}

	void withdraw(final double amt) {
		if (amt < 0) {
			throw new RuntimeException("You can't withdraw negative money!");
		}
		savingsBalance -= amt;
	}

	private double interestEarned;

	double getInterestEarned() {
		return interestEarned;
	}

	@Override
	void calculateMonthlyInterest() {
		double annualInterest = (
			super.savingsBalance > 10000
			? 0.1
			: 0.04
		);

		var currentInterest = savingsBalance * (annualInterest / 12);

		interestEarned += currentInterest;
		savingsBalance += currentInterest;
	}

	@Override
	public String toString() {
		return (""
			+ name + " {\n"
			+ "   savingsBalance = " + fmt(savingsBalance) + ";\n"
			+ "   interestEarned = " + fmt(interestEarned) + ";\n"
			+ "}\n"
		);
	}
}
