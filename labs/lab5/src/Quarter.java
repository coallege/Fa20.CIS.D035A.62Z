import java.util.stream.IntStream;

class Quarter {
	final int low;
	final float avg;
	final int high;

	Quarter(final IntStream i) {
		this.low  = i.min().orElse(0);
		this.avg  = (float) i.average().orElse(0);
		this.high = i.max().orElse(0);
	}
}
