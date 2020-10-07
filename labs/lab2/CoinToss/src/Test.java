import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		// if the user ran it with javaw
		if (true || System.console() == null) {
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

		short choice = 0;

		var sc = new Scanner(System.in);
		try {
			var line = sc.nextLine();
			choice = Short.parseShort(line);
		} catch (Exception e) { }

		sc.close();
		if (choice == 1) {
			GUI.run();
		} else {
			CUI.run();
		}
	}
}
