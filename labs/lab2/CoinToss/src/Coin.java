class Coin {
	static enum Face {
		heads,
		tails,
	};

	/* Get a random face */
	static Face flip() {
		return Math.random() > 0.5 ? Face.heads : Face.tails;
	}

	private Face sideUp;

	Coin() {
		this.toss();
	}

	void toss() {
		this.sideUp = flip();
	}

	Face getSideUp() {
		return this.sideUp;
	}

	private static final int TOSS_COUNT = 20;

	/**
	 * I would like to point out that performing tosses
	 * is not the job of the coin and in a real application
	 * should be separated out somewhere else.
	 *
	 * The assignment, however, states that the Coin class should
	 * have two toss methods where the second
	 * method (this one) tosses the coin 20 times.
	 */
	Face toss20()[] {
		var i = TOSS_COUNT;
		var res = new Face[TOSS_COUNT];
		while (i --> 0) {
			this.toss();
			res[i] = this.getSideUp();
		}
		return res;
	}
}
