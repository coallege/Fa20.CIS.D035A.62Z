import java.util.Arrays;
import java.util.stream.Stream;

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

	private final Stream<WeeklySales> salesStream;

	private void setSales(int day, double sale) {
		this.weeklySales[day / 7].salesByDay[day % 7] = sale;
	}

	@SuppressWarnings("unchecked")
	Store(final String name, final String line) {
		this.name = name;
		int day = 0;
		for (var sale
			: (Iterable<Float>) Arrays
				.stream(line.split("\t"))
				.map(Float::parseFloat))
					setSales(day++, sale);

		this.salesStream = Arrays.stream(this.weeklySales);
	}

	double total() {
		return this.salesStream
			.mapToDouble(ws -> ws.total())
			.sum();
	}

	double weeklyAverage() {
		return this.salesStream
			.mapToDouble(ws -> ws.total())
			.average()
			.orElse(0);
	}

	double dailyAverage() {
		return this.salesStream
			.mapToDouble(ws -> ws.dailyAverage())
			.average()
			.orElse(0);
	}

	WeeklySales lowestWeek() {
		return this.salesStream
			.min(WeeklySales::compareTotal)
			.orElse(null);
	}

	WeeklySales highestWeek() {
		return this.salesStream
			.max(WeeklySales::compareTotal)
			.orElse(null);
	}

	void display(final IndentBuffer ib) {
		ib.l("Store " + this.name);
		ib.block(() -> {
			ib.l("Total Sales              : " + this.total());
			ib.l("Average Weekly Sales     : " + this.weeklyAverage());
			ib.l("Average Daily Sales      : " + this.dailyAverage());
			ib.l("Week Highest Total Sales : " + this.highestWeek().name);
			ib.l("Week Lowest Total Sales  : " + this.lowestWeek().name);
		});

		for (var ws : this.weeklySales) {
			ib.block(ws::display);
		}
	}
}
