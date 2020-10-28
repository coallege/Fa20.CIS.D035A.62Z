import java.util.*;

class WeeklySales {
	/** Actually just the week number but let's keep the naming consistent */
	final int name; // it's actually kind of annoying that this is not a String

	WeeklySales(final int name) {
		this.name = name;
	}

	/**
	 * So this isn't ever filled with data within WeeklySales.
	 * The Store class is the one that actually fills this double array with data.
	 */
	final double[] salesByDay = new double[7];

	double total() {
		return Arrays
			.stream(this.salesByDay)
			.sum();
	}

	double dailyAverage() {
		return Arrays
			.stream(this.salesByDay)
			.average()
			.orElse(0);
	}

	/**
	 * The width of the number that is printed out.
	 * If it's less than 7, things are going to have a bad time.
	 */
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

	/* Looks like this if WIDTH = 10:
	   Week 5
         Weekly Total  : 43896.93
         Daily Average : 6270.99
         Sun        Mon        Tue        Wed        Thu        Fri        Sat
         6009.99    6096.99    6183.99    6270.99    6357.99    6444.99    6531.99
	*/
	void display(final IndentBuffer ib) {
		ib.l("Week " + this.name);
		ib.block(() -> {
			ib.f("Weekly Total  : %.2f", this.total());
			ib.f("Daily Average : %.2f", this.dailyAverage());
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

	/**
	 * When finding the lowest and the highest weeks, you need a Comparator.
	 * This function is that Comparator and is pulled from WeeklySales by Store.
	 */
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
