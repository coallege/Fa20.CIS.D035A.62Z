import java.util.Arrays;
import java.util.function.ToIntFunction;

class Student {
	private final int SID;

	private final int scores[] = new int[5];

	Student(final String line) {
		final var ary = (
			Arrays
				.stream(line.split(" "))
				.mapToInt(Integer::parseInt)
				.toArray()
		);
		this.SID = ary[0];
		for (var i = 1; i < 5; ++i) {
			this.setScore(i - 1, ary[i]);
		}
	}

	void setScore(final int quarter, final int score) {
		this.scores[quarter] = score;
	}

	int getSID() {
		return this.SID;
	}

	static ToIntFunction<Student> $getScore(final int quarter) {
		return s -> s.getScore(quarter);
	}
	int getScore(final int quarter) {
		return this.scores[quarter];
	}
}
