import java.util.List;

class Franchise {
	final Store[] stores;

	Franchise(List<String> lines) {
		var storeCount = Integer.parseInt(lines.remove(0));
		this.stores = new Store[storeCount];

		lines.remove(0); // remove the days

		var idx = 0;
		for (var line : lines) {
			this.stores[idx++] = new Store(line);
		}
	}

	void display(IndentBuffer ib) {
		for (var i = 0; i < this.stores.length; ++i) {
			ib.l("Store " + + + i);
			ib.block(this.stores[i]::display);
		}
	}
}
