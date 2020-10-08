import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		// if the user ran it with javaw
		if (System.console() == null) {
			GUI.run();
			return;
		}

		System.out.print(""
			+ "Please select your preferred display option:\n"
			+ "Please enter a number (default 0)\n"
			+ "[0] Console\n"
			+ "[1] GUI\n"
			+ "> "
		);

		var sc = new Scanner(System.in);
		var line = sc.nextLine();

		if (line.equals("1")) {
			GUI.run();
		} else {
			CUI.run(sc);
		}
	}
}
