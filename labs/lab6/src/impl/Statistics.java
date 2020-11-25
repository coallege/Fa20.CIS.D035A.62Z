package impl;

import adapter.*;
import static java.util.Arrays.stream;

public final class Statistics implements IStatistics {
	private final int low;
	private final float avg;
	private final int high;

	Statistics(final int[] scores) {
		this.low  = stream(scores).min().orElse(0);
		this.avg  = (float) stream(scores).average().orElse(0);
		this.high = stream(scores).max().orElse(0);
	}

	@Override
	public int low() { return this.low; }

	@Override
	public float avg() { return this.avg; }

	@Override
	public int high() { return this.high; }
}
