package impl;

import java.io.Serializable;
import java.util.StringJoiner;

@SuppressWarnings("serial")
public final class StudentGrade implements Serializable {
	protected final Student student;
	protected final Statistics statistics;

	public StudentGrade(final Student student, final Statistics statistics) {
		this.student = student;
		this.statistics = statistics;
	}

	@Override
	public String toString() {
		final var scores = new StringJoiner(", ");
		for (final var score : this.student.scores) {
			scores.add(Integer.toString(score));
		}

		return (
			new StringBuilder()
				.append("Student Grade [\n---Student---\n   id: #")
				.append(this.student.id)
				.append("\n   scores: ")
				.append(scores)
				.append("\n\n")
				.append("---Statistics---\n   high: ")
				.append(this.statistics.high)
				.append("\n   low: ")
				.append(this.statistics.low)
				.append("\n   avg: ")
				.append(this.statistics.avg)
				.append("\n]")
				.toString()
		);
	}
}
