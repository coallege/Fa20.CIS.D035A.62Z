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

	void display(IndentBuffer ib) {
		ib.l("Week " + this.name);
		
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
