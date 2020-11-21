import static java.util.Arrays.stream;

class Quarter {
	final int quarterNumber;

	final int low;
	final float avg;
	final int high;

	Quarter(final int quarterNumber, final int[] scores) {
		this.quarterNumber = quarterNumber;

		// leave the heavylifting to the IntStream API
		this.low  = stream(scores).min().orElse(0);
		this.avg  = (float) stream(scores).average().orElse(0);
		this.high = stream(scores).max().orElse(0);
	}

	@Override
	public String toString() {
		final var sb = new StringBuilder();

		return (
			sb
				.append("Quarter ")
				.append(this.quarterNumber)
				.append(" {\n   low : ")
				.append(this.low)
				.append("\n   avg : ")
				.append(String.format("%.2f", this.avg))
				.append("\n   high: ")
				.append(this.high)
				.append("\n}")
				.toString()
		);
	}
}
