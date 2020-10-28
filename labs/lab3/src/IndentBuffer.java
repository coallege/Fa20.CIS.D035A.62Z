import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class IndentBuffer {
	public static final String INDENT = "   ";
	private static final int DEFAULT_LIST_SIZE = 50;

	private final List<String> lines;

	IndentBuffer() {
		this(new ArrayList<>(DEFAULT_LIST_SIZE));
	}

	IndentBuffer(final List<String> list) {
		this.lines = list;
	}

	private String indent = "";

	void block(final Runnable fn) {
		var lastIndent = this.indent;
		this.indent = this.indent + INDENT;
		fn.run();
		this.indent = lastIndent;
	}

	void block(final Consumer<IndentBuffer> fn) {
		var lastIndent = this.indent;
		this.indent = this.indent + INDENT;
		fn.accept(this);
		this.indent = lastIndent;
	}

	/** Add a line */
	void l(final String line) {
		this.lines.add(indent + line);
	}

	void f(final String fmt, Object... o) {
		this.lines.add(indent + String.format(fmt, o));
	}

	void forEach(final Consumer<String> fn) {
		this.lines.forEach(fn);
	}

	String[] asArray() {
		return this.lines.toArray(new String[this.lines.size()]);
	}

	List<String> asList() {
		return Collections.unmodifiableList(this.lines);
	}

	void dumpStdout() {
		this.lines.forEach(System.out::println);
	}

	void dumpStderr() {
		this.lines.forEach(System.err::println);
	}

	void clear() {
		this.lines.clear();
	}
}
