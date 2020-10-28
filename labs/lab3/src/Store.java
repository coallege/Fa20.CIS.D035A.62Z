import java.util.Arrays;

class Store {
	final String name;

	final WeeklySales[] weeklySales = {
		new WeeklySales(1),
		new WeeklySales(2),
		new WeeklySales(3),
		new WeeklySales(4),
		new WeeklySales(5),
	};

	/** Gonna get a nice IndexOutOfBounds if you try to go above 35 days */
	private void setSales(final int day, final double sale) {
		this.weeklySales[day / 7].salesByDay[day % 7] = sale;
	}

	/**
	 * @param name The name used when displaying the Store in a text format.
	 * @param line It is the Store constructor's responsibility to parse the line
	 * and assign the WeeklySales based on the input.
	 */
	Store(final String name, final String line) {
		this.name = name;

		// split the line by tabs and parse each element as a double
		Iterable<Double> sales = Arrays
		.stream(line.split("\t"))
		.map(Double::parseDouble)::iterator;

		// then count the days and set the sales
		int day = 0;
		for (var sale : sales) {
			setSales(day++, sale);
		}
	}

	double total() {
		return Arrays
			.stream(this.weeklySales)
			.mapToDouble(ws -> ws.total())
			.sum();
	}

	double weeklyAverage() {
		return Arrays
			.stream(this.weeklySales)
			.mapToDouble(ws -> ws.total())
			.average()
			.orElse(0);
	}

	double dailyAverage() {
		return Arrays
			.stream(this.weeklySales)
			.mapToDouble(ws -> ws.dailyAverage())
			.average()
			.orElse(0);
	}

	WeeklySales lowestWeek() {
		return Arrays
			.stream(this.weeklySales)
			.min(WeeklySales::compareTotal)
			.orElse(null);
	}

	WeeklySales highestWeek() {
		return Arrays
			.stream(this.weeklySales)
			.max(WeeklySales::compareTotal)
			.orElse(null);
	}

	/* Looks like:
		Store 6
			Total Sales              : 176922.17
			Average Weekly Sales     : 35384.43
			Average Daily Sales      : 5054.92
			Week Highest Total Sales : Week 5
			Week Lowest Total Sales  : Week 1
	*/
	void display(final IndentBuffer ib) {
		ib.l("Store " + this.name);
		ib.block(() -> {
			ib.f("Total Sales              : %.2f", this.total());
			ib.f("Average Weekly Sales     : %.2f", this.weeklyAverage());
			ib.f("Average Daily Sales      : %.2f", this.dailyAverage());
			ib.l("Week Highest Total Sales : Week " + this.highestWeek().name);
			ib.l("Week Lowest Total Sales  : Week " + this.lowestWeek().name);
			for (var ws : this.weeklySales) {
				ws.display(ib);
			}
		});
	}
}
