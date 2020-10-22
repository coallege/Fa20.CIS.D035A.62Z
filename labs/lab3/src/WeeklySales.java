import java.util.*;

class WeeklySales {
	/** Actually just the week number but let's keep the naming consistent */
	final int name;

	WeeklySales(final int name) {
		this.name = name;
	}

	final double[] salesByDay = new double[7];

	double total() {
		return Arrays.stream(this.salesByDay).sum();
	}

	double dailyAverage() {
		return Arrays.stream(this.salesByDay).average().orElse(0);
	}

	private static final int WIDTH = 10;
	private static final String SPACES = " ".repeat(WIDTH - 2);
	private static final String WEEKDAYS = (""
		+ "Sun" + SPACES
		+ "Mon" + SPACES
		+ "Tue" + SPACES
		+ "Wed" + SPACES
		+ "Thu" + SPACES
		+ "Fri" + SPACES
		+ "Sat" + SPACES
	);

	void display(final IndentBuffer ib) {
		ib.l("Week " + this.name);
		ib.block(() -> {
			ib.f("Weekly Total  : %.2f", this.total());
			ib.f("Daily Average : %.2f", this.total());
			ib.l(WEEKDAYS);
			ib.f(
				("%-" + WIDTH + ".2f ").repeat(7),
				this.salesByDay[0],
				this.salesByDay[1],
				this.salesByDay[2],
				this.salesByDay[3],
				this.salesByDay[4],
				this.salesByDay[5],
				this.salesByDay[6]
			);
		});
	}

	static int compareTotal(final WeeklySales a, final WeeklySales b) {
		var aTotal = a.total();
		var bTotal = b.total();
		if (aTotal < bTotal) {
			return -1;
		}

		if (aTotal > bTotal) {
			return 1;
		}

		// implied:
		// if (aTotal == bTotal) {
			return 0;
		// }
	}
}
