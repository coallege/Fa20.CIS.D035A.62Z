import java.util.List;
import java.util.function.Consumer;

class IndentBuffer {
	final List<String> lines;

	IndentBuffer(List<String> list) {
		this.lines = list;
	}

	private static final String INDENT = "   ";
	private int indentCount = 0;

	private String indent = "";

	void indent() {
		this.indent = INDENT.repeat(++indentCount);
	}

	void outdent() {
		this.indent = INDENT.repeat(--indentCount);
	}

	void block(Consumer<IndentBuffer> fn) {
		var lastIndent = this.indent;
		this.indent = this.indent + INDENT;
		fn.accept(this);
		this.indent = lastIndent;
	}

	/** Add a line */
	void l(String line) {
		lines.add(indent + line);
	}
}
