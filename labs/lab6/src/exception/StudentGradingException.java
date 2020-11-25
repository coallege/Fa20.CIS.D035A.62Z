package exception;

import java.io.*;
import functional.*;

@SuppressWarnings("serial")
public class StudentGradingException extends RuntimeException {
	public static boolean setOutput(final File f) {
		final OutputStream fos;
		try {
			f.createNewFile();
			fos = new FileOutputStream(f);
		} catch (Throwable t) {
			return false;
		}
		StudentGradingException.setOutput(fos);
		return true;
	}

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
