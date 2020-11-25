package exception;

import java.io.*;
import functional.*;

@SuppressWarnings("serial")
public class StudentGradingException extends RuntimeException {
	public static void setOutput(final OutputStream os) {
		System.setErr(new PrintStream(os));
	}

	public static void fwd(final ThrowingRunnable fn) {
		try {
			fn.run();
		} catch (Throwable t) {
			throw new StudentGradingException(t);
		}
	}

	public StudentGradingException() {}
	public StudentGradingException(String msg) { super(msg); }
	public StudentGradingException(Throwable cause) { super(cause); }
}
