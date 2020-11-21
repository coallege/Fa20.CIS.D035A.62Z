import java.util.Arrays;
import java.util.function.ToIntFunction;

class Student {
	private final int SID;

	private final int scores[] = new int[5];

	Student(final String line) {
		final var tokens = (
			Arrays
				.stream(line.split(" "))
				.mapToInt(Integer::parseInt) // this can fail but it shouldn't
				.toArray()
		);

		this.SID = tokens[0];

		for (var i = 0; i < 5; ++i) {
			// i + 1 is because the first token is always the student id
			this.setScore(i, tokens[i + 1]);
		}
	}

	void setScore(final int quarter, final int score) {
		this.scores[quarter] = score;
	}

	int getSID() {
		return this.SID;
	}

	/**
	 * getScore :: Student s => s ~> int -> int
	 */
	int getScore(final int quarter) {
		return this.scores[quarter];
	}

	/**
	 * _getScore :: Student s => int -> s -> int
	 *
	 * Comparing the signature to getScore, I have parameterized the Student and
	 * flipped the args for a "data-last" kinda function.
	 */
	static ToIntFunction<Student> _getScore(final int quarter) {
		return s -> s.getScore(quarter);
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
