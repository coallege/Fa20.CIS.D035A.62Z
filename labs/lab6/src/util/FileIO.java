package util;

import impl.*;
import exception.*;

import java.io.*;

public class FileIO {
	public static void writeOut(
		final StudentGrade obj,
		final FileOutputStream fos
	)
	throws StudentGradingException
	{
		try (final var oos = new ObjectOutputStream(fos)) {
			oos.writeObject(obj);
		} catch (Throwable t) {
			throw new StudentGradingException(t);
		}
	}

	
}
