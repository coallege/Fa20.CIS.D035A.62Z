package driver;

import impl.*;
import constants.output_files;

import java.io.*;
import java.util.*;
import java.nio.file.*;


import static java.lang.System.*;

interface Viewer {
	static Scanner sc = new Scanner(System.in);
	static void main(final String[] args) {
		out.println(""
			+ "This class is for ease of grading and also serves\n"
			+ "as proof that the files were serialized correctly\n"
			+ "Please input the requirement/driver that you would\n"
			+ "like to review:\n"
			+ "[1] Driver1/Requirement 1\n"
			+ "[2] Driver2/Requirement 2\n"
			+ "[3] Driver3/Requirement 3\n"
		);

		while (true) {
			out.print("> ");
			try {
				final var line = sc.nextLine();
				if (line.length() != 1) {
					err.println("The input must be one character");
					continue;
				}

				switch (line.charAt(0)) {
					case '1':
						Viewer.driver1();
						return;
					case '2':
						Viewer.driver2();
						return;
					case '3':
						Viewer.driver3();
						return;
					default: {
						err.println("The input must be either 1, 2, or 3");
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
				err.println("Unexpected error. Try again.");
			}
		}
	}

	static void driver1() throws IOException {
		final var driver1_file = output_files.Driver1;

		out.println("\n"
			+ "Driver1 / Requirement 1 demonstrates proficiency in error handling.\n"
			+ "exception.StudentGradingException correctly captures any errors and logs them to a file.\n"
			+ "The program will now print the contents of that file.\n"
			+ "You should expect to see a stack trace.\n"
			+ "---" + driver1_file + "---\n\n"
			+ Files.readString(Paths.get(driver1_file))
			+ "\n---" + driver1_file + "---"
		);
	}

	static void driver2() {
		final var driver2_file = output_files.Driver2;

		try (
			final var fis = new FileInputStream(driver2_file);
			final var ois = new ObjectInputStream(fis);
		) {
			out.println("\n"
				+ "Driver2 / Requirement 2 demonstrates knowledge\n"
				+ "of the Serialization API built into to the JDK.\n"
				+ "The program will now deserialize the file " + driver2_file + ".\n"
			);

			out.println(ois.readObject());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	static void driver3() {
		final var driver3_file = output_files.Driver3;

		try (
			final var fis = new FileInputStream(driver3_file);
			final var ois = new ObjectInputStream(fis);
		) {
			out.println("\n"
				+ "Driver3 / Requirement 3 brings all the elements together.\n"
				+ "Multiple Students are serialized to a file.\n"
				+ "The program will now deserialize the file " + driver3_file + ".\n"
			);

			while (true) {
				try {
					out.println(ois.readObject());
				} catch (EOFException e) {
					// done
					return;
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
