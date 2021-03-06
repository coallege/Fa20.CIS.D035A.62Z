package driver;

import exception.*;
import constants.output_files;

import java.io.*;

/*
Demonstrate the usage of exception handler in a driver, throwing, logging and
fixing the exception. Put this in a separate driver called Driver1. java.
(Put this in driver package)
*/
interface Driver1 {
	static void main(final String[] args) throws StudentGradingException {
		try {
			throw new StudentGradingException("Throwing");
		} catch (StudentGradingException e) {
			System.err.println("Logging and Fixing");
		}

		// "Logs exceptions in a text file."
		final var errFile = new File(output_files.Driver1);
		final var err = StudentGradingException.setOutput(errFile);
		if (err) {
			return;
		}

		throw new StudentGradingException("I'm in a file!");
	}
}
