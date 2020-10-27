import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class IndentBuffer {
	private final List<String> lines;

	IndentBuffer(final List<String> list) {
		this.lines = list;
	}

	public static final String INDENT = "   ";

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

	List<String> list() {
		return Collections.unmodifiableList(this.lines);
	}

	void clear() {
		this.lines.clear();
	}
}
