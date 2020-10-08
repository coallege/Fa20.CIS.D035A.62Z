import static java.lang.System.out;
import java.util.Scanner;

class CUI {
	public static void run(Scanner sc) {
		out.print(""
			+ "What should I do?\n"
			+ "[0] Toss the coin once\n"
			+ "[1] Toss the coin twenty times\n"
			+ "[2] Quit\n"
		);

		var coin = new Coin();
		while (true) {
			out.print("> ");
			var line = sc.nextLine();
			if (line.equals("0")) {
				coin.toss();
				out.println(coin.getSideUp().toString());
			} else if (line.equals("1")) {
				int heads = 0;
				for (var face : coin.toss20()) {
					if (face == Coin.Face.heads) {
						heads++;
					}
					out.println(face.toString());
				}
				out.println("Heads: " + heads + "\nTails: " + (20 - heads));
			} else if (line.equals("2")) {
				break;
			}
		}
		sc.close();
	}
}
