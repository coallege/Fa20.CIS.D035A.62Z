package driver;

import java.io.FileOutputStream;

import exception.StudentGradingException;
import impl.*;
import util.FileIO;

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
			final var fos = new FileOutputStream("driver.Driver2.student_grade.ser");
			FileIO.writeOut(sg, fos);
			fos.close();
		});
	}
}
