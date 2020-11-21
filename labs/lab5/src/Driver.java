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
				.skip(2) // skip the first two lines because they don't have data
				.filter(new TFlipFlopPredicate())
				.map(Student::new)
				.collect(Collectors.toUnmodifiableList())
		);
		lines.close();

		for (var quarterNum = 0; quarterNum < 5; ++quarterNum) {
			// iterate over each of the students getting the
			// corresponding quarter scores for each of them
			final var scores = (
				students
					.stream()
					.mapToInt(Student._getScore(quarterNum))
					.toArray()
			);

			// typically, one would assign this to a Quarter[5] but
			// the instructions just say to print it out
			final var quarter = new Quarter(quarterNum + 1, scores);

			System.out.println(quarter);
		}
	}
}
