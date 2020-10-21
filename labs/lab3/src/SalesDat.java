import java.io.*;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.Scanner;

public class SalesDat {
	private static Supplier<Optional<File>> tryFile(final String path) {
		final var file = new File(path);
		return
			file.isFile()
			? () -> Optional.of(file)
			: Optional::empty;
	}

	private static final String ZPath = "Z:\\JavaPrograms2\\assignment336b\\src\\Salesdat.txt";

	private static Supplier<Optional<File>> ZFile() {
		return
			System.getProperty("os.name").startsWith("Windows")
			? tryFile(ZPath)
			: Optional::empty;
	}

	private static final Scanner sc = new Scanner(System.in);
	private static File prompt() {
		System.out.print("Please enter the path to Salesdat.txt\n> ");
		try {
			var file = new File(sc.nextLine());

			while (!file.isFile()) {
				System.out.print(file.getAbsolutePath() + " is not a regular file.\nTry again\n> ");
				file = new File(sc.nextLine());
			}

			return file;
		} catch (Exception e) {
			System.out.println("Exiting...");
			System.exit(1);
			return null;
		}
	}

	public static FileReader location;

	static {
		var file = Optional.<File>empty()
			.or(ZFile())
			.or(tryFile("./salesdat.txt"))
			.or(tryFile("./Salesdat.txt"))
			.or(tryFile("./src/salesdat.txt"))
			.or(tryFile("./src/Salesdat.txt"))
			.or(tryFile("./bin/salesdat.txt"))
			.or(tryFile("./bin/Salesdat.txt"))
			.or(tryFile("../src/salesdat.txt"))
			.or(tryFile("../src/Salesdat.txt"))
			.or(tryFile("../bin/salesdat.txt"))
			.or(tryFile("../bin/Salesdat.txt"))
			.or(tryFile("../salesdat.txt"))
			.or(tryFile("../Salesdat.txt"))
			.orElse(prompt());

		try {
			location = new FileReader(file);
			System.out.println("Found " + file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("Could not find Salesdat.txt: " + file.getAbsolutePath());
		}
	}
}
