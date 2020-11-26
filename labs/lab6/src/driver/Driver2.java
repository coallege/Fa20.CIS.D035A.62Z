package driver;

import impl.*;
import exception.*;
import constants.output_files;

import util.*;
import java.io.*;

interface Driver2 {
	static void main(final String[] args) throws StudentGradingException {
		final var student = new Student(0);
		student.setScore(0, 97);
		student.setScore(1, 84);
		student.setScore(2, 100);
		student.setScore(3, 89);
		student.setScore(4, 75);

		final var stats = new Statistics(student.scores());

		final var sg = new StudentGrade(student, stats);

		StudentGradingException.fwd(() -> {
			final var fos = new FileOutputStream(output_files.Driver2);
			FileIO.writeOut(sg, fos);
			fos.close();
		});
	}
}
