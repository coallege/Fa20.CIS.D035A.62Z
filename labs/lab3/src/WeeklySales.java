import java.util.*;

class WeeklySales implements Display {
	final double[] salesByDay = new double[7];

	double total() {
		return Arrays.stream(this.salesByDay).sum();
	}

	double average() {
		return Arrays.stream(this.salesByDay).average().orElse(0);
	}

	public List<String> display() {
		
	}
}
