import java.util.Arrays;

class Quarter {
	final int quarterNumber;

	final int low;
	final float avg;
	final int high;

	Quarter(final int quarterNumber, final int[] scores) {
		this.quarterNumber = quarterNumber;

		this.low  = Arrays.stream(scores).min().orElse(0);
		this.avg  = (float) Arrays.stream(scores).average().orElse(0);
		this.high = Arrays.stream(scores).max().orElse(0);
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
				.append("\n}\n")
				.toString()
		);
	}
}
