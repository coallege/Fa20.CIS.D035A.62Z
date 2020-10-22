import java.util.Arrays;
import java.util.List;

class Franchise {
	final Store[] stores;
	final String name;

	Franchise(final String name, final List<String> lines) {
		this.name = name;

		var storeCount = Integer.parseInt(lines.remove(0));
		this.stores = new Store[storeCount];

		lines.remove(0); // remove the days

		var idx = 0;
		for (var line : lines) {
			this.stores[idx++] = new Store(Integer.toString(idx), line);
		}
	}

	double total() {
		return Arrays
			.stream(this.stores)
			.mapToDouble(store -> store.total())
			.sum();
	}

	double dailyAverage() {
		return Arrays
			.stream(this.stores)
			.mapToDouble(store -> store.dailyAverage())
			.sum();
	}

	void display(IndentBuffer ib) {
		ib.l("Franchise " + this.name);
		ib.block(() -> {
			ib.f("Franchise Total Sales         : %.2f", this.total());
			ib.f("Franchise Average Daily Sales : %.2f", this.dailyAverage());
		});

		for (var store : this.stores) {
			ib.block(store::display);
		}
	}
}
