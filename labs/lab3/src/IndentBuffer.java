import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class IndentBuffer {
	/**
	 * Each indent level has these characters in front.
	 */
	public static final String INDENT = "   ";

	/**
	 * Sometimes, you don't want to make a new ArrayList by hand because it takes
	 * a lot of typing. The nullary constructor will make the ArrayList for you
	 * with the capacity of DEFAULT_LIST_SIZE.
	 */
	private static final int DEFAULT_LIST_SIZE = 50;

	IndentBuffer() {
		this(new ArrayList<>(DEFAULT_LIST_SIZE));
	}

	private final List<String> lines;

	IndentBuffer(final List<String> list) {
		this.lines = list;
	}

	private String currentIndent = "";

	/**
	 * both <code>block</code> methods are used to keep indents for leaking,
	 * kinda. In this way, you can't ever forget to outdent because the function
	 * will take care of it.
	 */

	void block(final Runnable fn) {
		var lastIndent = this.currentIndent;
		this.currentIndent = this.currentIndent + INDENT;
		fn.run();
		this.currentIndent = lastIndent;
	}

	/**
	 * This one is probably mostly unused but I'll leave it in here
	 */
	void block(final Consumer<IndentBuffer> fn) {
		var lastIndent = this.currentIndent;
		this.currentIndent = this.currentIndent + INDENT;
		fn.accept(this);
		this.currentIndent = lastIndent;
	}

	/** Add a line. The function name is short because I call it a lot. */
	void l(final String line) {
		this.lines.add(currentIndent + line);
	}

	/** When you want to add a line but also use sprintf */
	void f(final String fmt, Object... o) {
		this.lines.add(currentIndent + String.format(fmt, o));
	}

	void forEach(final Consumer<String> fn) {
		this.lines.forEach(fn);
	}

	String[] asArray() {
		return this.lines.toArray(new String[this.lines.size()]);
	}

	List<String> asList() {
		/**
		 * Freeze! Don't move!
		 * Just from an API perspective, I don't want people, including myself, to
		 * mutate the List in ways I don't like.
		 */
		return Collections.unmodifiableList(this.lines);
	}

	/**
	 * Convenient helper function to just dump all the lines to stdout because
	 * that's probably where they were going anyways.
	 */
	void dumpStdout() {
		this.lines.forEach(System.out::println);
	}

	void dumpStderr() {
		this.lines.forEach(System.err::println);
	}
}
