package impl;

import adapter.*;

import java.util.Arrays;

public final class Student implements IStudent {
	private final int id;

	private final int scores[] = new int[5];

	Student(final String line) {
		final var tokens = (
			Arrays
				.stream(line.split(" "))
				.mapToInt(Integer::parseInt) // this can fail but it shouldn't
				.toArray()
		);

		this.id = tokens[0];

		for (var i = 0; i < 5; ++i) {
			// i + 1 is because the first token is always the student id
			this.setScore(i, tokens[i + 1]);
		}
	}

	Student(final int id) {
		this.id = id;
	}

	int getScore(final int quarter) {
		return this.scores[quarter];
	}

	void setScore(final int quarter, final int score) {
		this.scores[quarter] = score;
	}

	@Override
	public int id() {
		return this.id;
	}

	@Override
	public int[] scores() {
		return this.scores;
	}

	@Override
	public IStatistics stats() {
		return new Statistics(this.scores);
	}
}
