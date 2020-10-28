import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FranchiseTest {
	@Test
	public void throwsIfListProvidedIsImmutable() {
		assertThrows(UnsupportedOperationException.class, () -> {
			new Franchise("UOE Test", Arrays.asList(new String[]{}));
		});
	}

	private void ioobe() {
		var list = new ArrayList<String>(5);
		list.add("3");
		list.add("DAYS");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		new Franchise("OOBE Test", list);
	}

	@Test
	public void oobeIfMoreLinesThanExpected() {
		assertThrows(IndexOutOfBoundsException.class, this::ioobe);
	}

	private void nfe() {
		var list = new ArrayList<String>(5);
		list.add("1");
		list.add("DAYS");
		list.add("not a number");
		new Franchise("NFE Test", list); // this will error all the way down in store
	}

	@Test
	public void nfeIfThereIsNotANumber() {
		assertThrows(NumberFormatException.class, this::nfe);
	}
}
