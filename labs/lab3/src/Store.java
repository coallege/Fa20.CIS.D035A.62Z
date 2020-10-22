import java.util.Arrays;

public class Store {
	final WeeklySales[] sales = new WeeklySales[5];

	private void setSales(int day, double sale) {
		this.sales[day / 7].salesByDay[day % 7] = sale;
	}

	@SuppressWarnings("unchecked")
	Store(String line) {
		int day = 0;
		for (var sale
			: (Iterable<Float>) Arrays
				.stream(line.split("\t"))
				.map(Float::parseFloat))
					setSales(day++, sale);
	}

	void printData() {
		for (int week = 0; week < 5; ++week) {
			for (int day = 0; day < 7; ++day) {
				System.out.printf("%-8d", this.sales[week].salesByDay[day]);
			}
		}
	}
	// businessmethod
	// a. totalsalesforweek
	// b. avgsalesforweek
	// c. totalsalesforallweeks
	// d. averageweeklysales
	// e. weekwithhighestsaleamt
	// f. weekwithlowestsaleamt
	// analyzeresults //call a through f
	// print()
}
