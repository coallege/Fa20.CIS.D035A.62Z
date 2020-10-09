import static java.lang.System.out;
import java.util.Scanner;

class CUI {
	private static Coin coin = new Coin();
	public static void run(Scanner sc) {
		out.print(""
			+ "What should I do?\n"
			+ "[0] Toss the coin once\n"
			+ "[1] Toss the coin twenty times\n"
			+ "[2] Quit\n"
		);

		while (true) {
			out.print("> ");
			var line = sc.nextLine();
			if (line.equals("0")) {
				tossOnce();
			} else if (line.equals("1")) {
				toss20Times();
			} else if (line.equals("2")) {
				break;
			}
		}
		sc.close();
	}

	private static void tossOnce() {
		coin.toss();
		out.println(coin.getSideUp().toString());
	}

	private static void toss20Times() {
		int heads = 0;
		for (var face : coin.toss20()) {
			if (face == Coin.Face.heads) {
				heads++;
			}
			out.println(face.toString());
		}
		out.println("Heads: " + heads + "\nTails: " + (20 - heads));
	}
}
