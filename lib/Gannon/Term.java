package Gannon;

import static java.lang.System.*;

public class Term {
	/** Clears the terminal */
	public static void clear() {
		clearVT100();
		if (OS.isWindows) {
			clearConhost();
		}
	}

	private static void clearConhost() {
		Flow.unchecked(() -> {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		});
	}

	private static void clearVT100() {
		out.print("\033[H\033[2J");
		out.flush();
	}
}
