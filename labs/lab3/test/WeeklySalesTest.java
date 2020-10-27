import org.junit.Test;
import static org.junit.Assert.*;

public class WeeklySalesTest {
	private WeeklySales emptyWS = new WeeklySales(8080);

	@Test
	public void weeklySalesArrayIsNotNull() {
		assertNotNull(emptyWS.salesByDay);
	}

	@Test
	public void weeklySalesArrayIs7() {
		assertEquals(7, emptyWS.salesByDay.length);
	}

	@Test
	public void emptyGivesZeroTotal() {
		assertEquals(0, emptyWS.total(), 0.001);
	}

	// @Test
	// public void emptyAverageThrows() {
	// 	assertThrows(DivideByZeroException.class, () -> {
	// 		emptyWS.dailyAverage();
	// 	});
	// }

	private WeeklySales sevenWS = new WeeklySales(7);

	public WeeklySalesTest() {
		int i = 7;
		while (i --> 0) {
			sevenWS.salesByDay[i] = 7;
		}
	}

	@Test
	public void sevenWSTotalIsRight() {
		assertEquals(7 * 7, sevenWS.total(), 0);
	}

	@Test
	public void sevenWSTotalIsSeven() {
		assertEquals(7, emptyWS.dailyAverage(), 7);
	}
}
