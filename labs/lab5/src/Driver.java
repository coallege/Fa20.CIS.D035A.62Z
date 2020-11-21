import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;

public interface Driver {
	static void main(final String[] args) throws IOException {
		final String filename;
		if (args.length < 1) {
			filename = "input.txt";
		} else {
			filename = args[0];
		}

		final var lines = Files.lines(Paths.get(filename));

		final var students = (
			lines
				.skip(2)
				.filter(new TFlipFlopPredicate<String>())
				.map(Student::new)
				.collect(Collectors.toUnmodifiableList())
		);
		lines.close();

		students.forEach(System.out::println);

		final var quarters = new Quarter[5];

		for (var qnum = 0; qnum < 5; ++qnum) {
			final var scores = (
				students
					.stream()
					.mapToInt(Student._getScore(qnum))
					.toArray()
			);

			quarters[qnum] = new Quarter(qnum + 1, scores);
		}

		for (final var quarter : quarters) {
			System.out.println(quarter);
		}
	}
}
