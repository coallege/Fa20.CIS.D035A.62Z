import java.nio.file.*;
import java.util.Optional;

class InputFile {
	// all that for a string that's not even longer than it's declaration
	/** What the file should start with */
	private static final String magic = "Stud Qu1 Qu2 Qu3 Qu4 Qu5";

	/** Test if the first line of a file begins with the magic */
	private static boolean isMagic(final Path file) {
		try (final var lines = Files.lines(file)) {
			return (
				lines
					.findFirst()
					.map(s -> s.startsWith(magic))
					.orElse(false)
			);
		} catch (Throwable e) {
			return false;
		}
	}

	private static Optional<Path> searchFor() {
		try (final var files = Files.walk(Paths.get(".."))) {
			return (
				files
					.filter(Files::isRegularFile)
					.filter(InputFile::isMagic)
					.findFirst()
			);
		} catch (Throwable e) {
			return Optional.empty();
		}
	}

	// this would be way better as a Result<Path, String> but whatever
	final Optional<Path> file;

	InputFile() {
		this.file = InputFile.searchFor();
	}

	InputFile(final String filename) {
		final var maybeFile = Paths.get(filename);
		if (isMagic(maybeFile)) {
			this.file = Optional.of(maybeFile);
		} else {
			this.file = Optional.empty();
		}
	}
}
