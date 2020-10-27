import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

// this test file can be small since I'm mostly worried about functions that
// I've written

public class StoreTest {
	private Store s = new Store("Test Store", "30\t70\t60\t40\t50\t100\t0\t0\t0\t39");

	@Test
	public void fucasda() {
		IndentBuffer.stdoutBuffer(s::display);
	}
}
