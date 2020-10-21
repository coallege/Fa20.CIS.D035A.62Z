import java.util.Arrays;

public class Store {
	/**
	 * [week_number][day_number]
	 */
	public final float[][] sales = new float[5][7];

	private void setSales(short day, float sale) {
		this.sales[day / 7][day % 7] = sale;
	}

	@SuppressWarnings("unchecked")
	Store(String line) {
		short day = 0;
		for (var sale
			: (Iterable<Float>) Arrays
				.stream(line.split("\t"))
				.map(Float::parseFloat))
					setSales(day++, sale);
	}

	public void printData() {
		for (short week = 0; week < 5; ++week) {
			for (short day = 0; day < 7; ++day) {
				System.out.printf("%-8d", this.sales[week][day]);
			}
		}
	}
	// float [] getsalesforentireweek(int week)
	// float getsaleforweekdayintersection(int week, int day)
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
