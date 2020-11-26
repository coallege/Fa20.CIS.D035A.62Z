package exception;

import java.io.*;
import functional.*;

@SuppressWarnings("serial")
public class StudentGradingException extends Exception {
	public static boolean setOutput(final File f) {
		final OutputStream fos;
		try {
			f.createNewFile();
			fos = new FileOutputStream(f);
		} catch (Throwable t) {
			return true;
		}
		StudentGradingException.setOutput(fos);
		return false;
	}

	public static void setOutput(final OutputStream os) {
		System.setErr(new PrintStream(os));
	}

	public static void fwd(final ThrowingRunnable fn) throws StudentGradingException {
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
