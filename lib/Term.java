import static java.lang.System.*;
import java.util.Scanner;

public class Term {
	/** Clears the terminal */
	public static void clear() {
		clearVT100();
		if (OS.isWindows) {
			clearConhost();
		}
	}

	private static void clearConhost() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Throwable t) {}
	}

	private static void clearVT100() {
		out.print("\033[H\033[2J");
		out.flush();
	}

	private static Scanner sc = new Scanner(System.in);
	public static String prompt(final String s) {
		out.print(s + "\n> ");
		return sc.nextLine();
	}
}
