import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import static java.lang.System.*;

public interface Driver {
	static void main(final String[] args) {
		final InputFile iF;
		if (args.length < 1) {
			out.print("No path provided in command line arguments.\nSearching...\n");
			iF = new InputFile();
		} else {
			iF = new InputFile();
		}

		final var file = iF.file.orElseThrow(
			// these are some microsoft tier error messages.
			// so much for being detailed but I blame Java
			// for not having a Result<T, E>
			() -> new Error("Error reading the input file.")
		);
		out.println("Working with " + util.realpath(file));

		try (final var lines = Files.lines(file)) {
			final var students = (
				lines
					.skip(2) // skip the first two lines because they don't have data
					.filter(new TFlipFlopPredicate())
					.map(Student::new)
					.collect(Collectors.toUnmodifiableList())
			);

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
				out.println(
				new Quarter(quarterNum + 1, scores)
				);
			}
		} catch (IOException e) {
			err.println("Something went wrong reading the file.");
			e.printStackTrace();
		}
	}
}
