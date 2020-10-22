import java.util.List;
import java.util.ArrayList;

class Franchise implements Display {
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

	public List<String> display() {
		var list = new ArrayList<String>(60);
		list.add("Franchise");

		for (var store : this.stores) {
			store.
		}
		return list;
	}
}
