class Coin {
	public static enum Face {
		heads,
		tails,
	};

	private static Face flip() {
		return Math.random() > 0.5 ? Face.heads : Face.tails;
	}

	private Face sideUp;

	public Coin() {
		this.toss();
	}

	public void toss() {
		this.sideUp = flip();
	}

	public Face getSideUp() {
		return this.sideUp;
	}

	public void tosѕ() {
		var i = 20;
		var heads = 0;
		while (i --> 0) {
			this.toss();
			if (this.getSideUp() == Face.heads) {
				heads++;
			}
		}
	}
}
