import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import static java.lang.System.out;

public class BabylonianMethod {
	public static double tolerance = 0.0001;

	/** clears the terminal */
	private static void clear() {
		out.print("\033[3J\033[H\033[2J");
	}
	/**
	 * This entire main function is just the terminal printing stuff
	 */
	public static void main(String[] dummy) {
		clear();
		out.println(""
			+ "BabylonianMethod.java\n"
			+ "Author: Cole Gannon\n"
			+ "(ctrl+c to exit)\n"
			+ "---------------------"
		);
		var sc = new Scanner(System.in);
		loop:
		while (true) {
			out.print("> ");

			String sin;
			try {
				sin = sc.nextLine();
			} catch (Exception e) {
				out.println("BLANK\nInterrupt. Exiting...");
				return;
			}

			long in;
			try {
				in = Long.parseLong(sin);
			} catch (NumberFormatException e) {
				out.println("\033[1A\033[K> ILLEGAL INPUT");
				continue loop;
			}

			out.printf("Math.sqrt  : %20f\n",  Math.sqrt(in));
			out.printf("Babylonian : %20f\n", sqrt(in));
			out.printf("Difference : %20f\n\n", Math.abs(Math.sqrt(in) - sqrt(in)));
		}
		sc.close();
	}

	/**
	 * Get the square root of a number using a trampoline'd version of the
	 * Babylonian Method.
	 */
	public static double sqrt(long n) {
		double old;
		// double next = n / 2; // could be any positive number but this is an okay start
		double next = 1;
		do {
			old = next;
			next = (old + n / old) / 2;
		} while (Math.abs(old - next) > tolerance);

		return next;
	}

	/**
	 * Get the square root using the recursive Babylonian Method (the way they did it)
	 */
	public static double sqrt_r(long n) {
		return sqrt_r(n, n / 2); // sigh... no default arguments still
	}

	public static double sqrt_r(long n, double initialGuess) {
		double nextGuess = (initialGuess + n / initialGuess) / 2;
		if (Math.abs(nextGuess - initialGuess) > tolerance) {
			return sqrt_r(n, nextGuess);
		} else {
			return nextGuess;
		}
	}
}
