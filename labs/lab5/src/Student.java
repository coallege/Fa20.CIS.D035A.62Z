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
		for (var i = 0; i < 5; ++i) {
			this.setScore(i, ary[i + 1]);
		}
	}

	void setScore(final int quarter, final int score) {
		this.scores[quarter] = score;
	}

	int getSID() {
		return this.SID;
	}

	static ToIntFunction<Student> _getScore(final int quarter) {
		return s -> s.getScore(quarter);
	}

	int getScore(final int quarter) {
		return this.scores[quarter];
	}

	@Override
	public String toString() {
		final var sb = new StringBuilder(64);
		sb
			.append("Student ")
			.append(this.SID)
			.append(" {\n");

		for (var i = 0; i < 5; ++i) {
			sb
				.append("   Quarter ")
				.append(i + 1)
				.append(": ")
				.append(this.getScore(i))
				.append('\n');
		}

		sb.append("}\n");
		return sb.toString();
	}
}
