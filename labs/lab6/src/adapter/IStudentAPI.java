package adapter;

import exception.*;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public interface IStudentAPI<E extends StudentGradingException> {
	/** read input using the default reader */
	void readInput() throws E;
	/** read input from a file */
	void readInput(final File f) throws E;
	/** read input from a path */
	void readInput(final Path p) throws E;
	/**
	 * read input from a String.
	 * This method does not interpret the String as a path but rather,
	 * the data itself.
	 */
	void readInput(final String s) throws E;

	Set<Integer> getStudentIds();
	IStudent getStudent(final int id);

	void setSerialStream(final OutputStream os) throws E;
	/** Writes the specified Student to the Serial OutputStream */
	void serializeStreamStudent(final int id) throws E;
	/** Serializes the Student to a String and returns the String */
	byte[] serializeStudent(final int id) throws E;
}
