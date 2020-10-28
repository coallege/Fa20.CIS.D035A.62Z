import org.junit.Test;
import static org.junit.Assert.*;

// this test file can be small since I'm mostly worried about functions that
// I've written

public class StoreTest {
	private Store s = new Store("Test Store", "30\t70\t60\t40\t50\t100\t0\t0\t0\t50");

	@Test
	public void testStoreWkAverageIs80() {
		assertEquals(80, s.weeklyAverage(), 0);
	}

	@Test
	public void highestSalesIsWeek1() {
		assertEquals(s.weeklySales[0], s.highestWeek());
	}

	private void oobe() {
		new Store("NPE", "0\t".repeat(35) + "0");
	}

	@Test
	public void throwsOOBEAfter35Days() {
		assertThrows(IndexOutOfBoundsException.class, this::oobe);
	}
}
