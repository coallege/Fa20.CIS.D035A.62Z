package util;

import java.io.File;
import java.nio.file.*;

public class InputFile {
	// all that for a string that's not even longer than it's declaration
	/** What the file should start with */
	private static final String magic = "Stud Qu1 Qu2 Qu3 Qu4 Qu5";

	public static boolean isMagic(final String s) {
		return s.startsWith(InputFile.magic);
	}

	/** Test if the first line of a file begins with the magic */
	public static boolean isMagic(final Path file) {
		try (final var lines = Files.lines(file)) {
			return (
				lines
					.findFirst()
					.map(s -> s.startsWith(InputFile.magic))
					.orElse(false)
			);
		} catch (Throwable e) {
			return false;
		}
	}

	/**
	 * In the grandparent directory of this process, get the
	 * first regular file that starts with `InputFile.magic`.
	 */
	public static Path searchFor() {
		final var grandparent = Paths.get("../../");
		try (final var files = Files.walk(grandparent)) {
			return (
				files
					.filter(Files::isRegularFile)
					.filter(InputFile::isMagic)
					.findFirst()
					.orElse(null)
			);
		} catch (Throwable e) {
			return null;
		}
	}
}
