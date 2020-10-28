import java.util.Arrays;
import java.util.List;

class Franchise {
	final Store[] stores;
	final String name;

	/**
	 * @param name The name of the Franchise.
	 * Used for displaying it in a text format.
	 * @param lines Each line of the Salesdat.txt.
	 * It's the Franchise's job to take in the data and turn it into real Java
	 * Objects. See how it does it below:
	 */
	Franchise(final String name, final List<String> lines) {
		this.name = name;

		// The first line of a Salesdat-like textfile is always the number of
		// Stores in the Franchise. It might seem weird that I'm removing it, but
		// lines.remove(0) actually returns the value of the first line too.
		var storeCount = Integer.parseInt(lines.remove(0));
		// Since we know the number of stores in the Franchise, let's make the
		// Store array right now.
		this.stores = new Store[storeCount];

		// The next line is just the day numbers.
		// I don't care about that at all.
		lines.remove(0);

		var storeNumber = 0;
		for (var line : lines) {
			// here's where the rest of the magic happens
			// each line of what's left of the Salesdat file (remember I removed 2)
			// corresponds to a single Store. Let's let the Store do the hard work
			// of parsing one line to keep Franchise simple.
			this.stores[storeNumber++] = new Store(Integer.toString(storeNumber), line);
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
		// indent once and...
		ib.block(() -> {
			ib.f("Franchise Total Sales         : %.2f", this.total());
			ib.f("Franchise Average Daily Sales : %.2f", this.dailyAverage());
			for (var store : this.stores) {
				// get the stores to display their values
				store.display(ib);
			}
		});
	}
}
