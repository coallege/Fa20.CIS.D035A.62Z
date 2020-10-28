import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

public class Driver {
	public static void main(String[] args) {
		// keeping it simple here,
		// read every line of the SalesDat file into a List
		List<String> lines;
		try {
			// let's let the SalesDat class take care of finding where the file is
			// for us so that we can keep the file reading simple
			lines = Files.readAllLines(SalesDat.path);
		} catch (Exception e) {
			System.err.println("Could not read " + SalesDat.path.toAbsolutePath());
			System.exit(1);
			return;
		}

		var f = new Franchise("Unknown Franchise", lines);
		// Using 200 for the ArrayList because I already know that there're about
		// 200 lines that are going to be written
		// In case it wasn't clear, that ArrayList is a list of each Line
		var ib = new IndentBuffer(new ArrayList<>(200));
		// ask the Franchise to write it's information to this IndentBuffer
		// instead of stdout. It makes it much more tidy.
		f.display(ib);
		// now all at once, we print each element of the ArrayList to stdout
		ib.dumpStdout();
	}
}
