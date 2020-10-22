import java.util.List;
import java.nio.file.Files;

public class Driver {
	public static void main(String[] args) {
		List<String> lines;
		try {
			lines = Files.readAllLines(SalesDat.path);
		} catch (Exception e) {
			System.err.println("Could not read " + SalesDat.path.toAbsolutePath());
			System.exit(1);
			return;
		}

		var f = new Franchise(lines);
		for (var line : Franchise.display()) {
			System.out.println(line);
		}
	}
}
