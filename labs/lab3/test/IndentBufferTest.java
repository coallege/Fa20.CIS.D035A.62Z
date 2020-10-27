import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class IndentBufferTest {
	private IndentBuffer ib = new IndentBuffer(new ArrayList<>());

	@Test
	public void blockDoesIndent() {
		ib.clear();
		ib.l("initial");
		ib.block(() -> {
			ib.l("test");
		});

		var lines = ib.list();
		assertEquals("initial", lines.get(0));
		assertEquals(IndentBuffer.INDENT + "test", lines.get(1));
	}

	@Test
	public void blockDoesOutdent() {
		ib.clear();
		ib.l("initial");
		ib.block(() -> {});
		ib.l("outdent");
		var lines = ib.list();
		assertEquals("initial", lines.get(0));
		assertEquals("outdent", lines.get(1));
	}

	@Test
	public void totalMakesSense() {
		ib.l("one");
		ib.l("two");
		ib.l("3");
		ib.block(() -> {
			ib.l("four");
			ib.l("5");
			ib.l("6");
			ib.block($ib -> {
				ib.l("seven");
			});
			ib.l("8");
		});
		ib.l("9");
		ib.l("ten");

		var lines = ib.list().toArray(new String[10]);
		String[] expected = {
			"one",
			"two",
			"3",
			IndentBuffer.INDENT + "four",
			IndentBuffer.INDENT + "5",
			IndentBuffer.INDENT + "6",
			IndentBuffer.INDENT + IndentBuffer.INDENT + "seven",
			IndentBuffer.INDENT + "8",
			"9",
			"ten",
		};
		assertArrayEquals(expected, lines);
	}
}
