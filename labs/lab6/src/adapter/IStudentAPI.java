package adapter;

import java.io.*;
import java.nio.file.*;

public interface IStudentAPI {
	/** read input using the default reader */
	void readInput();
	/** read input from a file */
	void readInput(final File f);
	/** read input from a path */
	void readInput(final Path p);
	/**
	 * read input from a String.
	 * This method does not interpret the String as a path but rather,
	 * the data itself.
	 */
	void readInput(final String s);

	int[] getStudentIds();
	IStudent getStudent(final int id);

	/** Writes the specified Student to the Serial OutputStream */
	void serializeStreamStudent(final int id);
	/** Serializes the Student to a String and returns the String */
	String serializeStringStudent(final int id);

	void setErrorStream(final OutputStream os);
	void setSerialStream(final OutputStream os);
}
