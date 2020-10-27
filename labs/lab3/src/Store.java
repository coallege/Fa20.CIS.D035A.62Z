import java.util.Arrays;

class Store {
	final String name;

	/** Gonna get a nice NPE if you try to go above 35 days */
	final WeeklySales[] weeklySales = {
		new WeeklySales(1),
		new WeeklySales(2),
		new WeeklySales(3),
		new WeeklySales(4),
		new WeeklySales(5),
	};

	private void setSales(final int day, final double sale) {
		this.weeklySales[day / 7].salesByDay[day % 7] = sale;
	}

	Store(final String name, final String line) {
		this.name = name;
		int day = 0;
		Iterable<Double> sales = Arrays.stream(line.split("\t")).map(Double::parseDouble)::iterator;
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

	void display(final IndentBuffer ib) {
		ib.l("Store " + this.name);
		ib.block(() -> {
			ib.f("Total Sales              : %.2f", this.total());
			ib.f("Average Weekly Sales     : %.2f", this.weeklyAverage());
			ib.f("Average Daily Sales      : %.2f", this.dailyAverage());
			ib.l("Week Highest Total Sales : Week " + this.highestWeek().name);
			ib.l("Week Lowest Total Sales  : Week " + this.lowestWeek().name);
		});

		for (var ws : this.weeklySales) {
			ib.block(ws::display);
		}
	}
}
