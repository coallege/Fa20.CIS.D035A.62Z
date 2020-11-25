package impl;


import util.*;
import adapter.*;
import exception.*;
import functional.*;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

@SuppressWarnings("rawtypes")
public class StudentAPI implements IStudentAPI {
	private final Map<Integer, Student> students = new HashMap<>();

	private void _readInput(final Stream<String> lines) {
		lines
			.skip(2) // skip the first two lines because they don't have data
			.filter(new TFlipFlopPredicate())
			.map(Student::new)
			.forEach(s -> this.students.put(s.id, s));
	}

	private void _readInput(final Path p) throws StudentGradingException {
		System.out.println("impl.StudentAPI: Reading input from " + p);
		StudentGradingException.fwd(() -> {
			this._readInput(Files.lines(p));
		});
	}

	@Override
	public void readInput() throws StudentGradingException {
		final var maybeFile = InputFile.searchFor();
		if (maybeFile == null) {
			throw new StudentGradingException("Could not find an input file!");
		}

		this._readInput(maybeFile);
	}

	@Override
	public void readInput(final File f) throws StudentGradingException {
		this.readInput(f.toPath());
	}

	@Override
	public void readInput(final Path p) throws StudentGradingException {
		if (!InputFile.isMagic(p)) {
			throw new StudentGradingException(
				p.toString() + " is not the right file format!"
			);
		}

		this._readInput(p);
	}

	@Override
	public void readInput(final String s) throws StudentGradingException {
		if (!InputFile.isMagic(s)) {
			throw new StudentGradingException(
				"The string provided is not in the right format!"
			);
		}

		this._readInput(s.lines());
	}

	@Override
	public Set<Integer> getStudentIds() {
		return this.students.keySet();
	}

	@Override
	public IStudent getStudent(final int id) {
		return this.students.get(id);
	}

	private ObjectOutputStream oos;

	@Override
	public void setSerialStream(final OutputStream os)
	throws StudentGradingException {
		try {
			this.oos = new ObjectOutputStream(os);
		} catch (Throwable t) {
			throw new StudentGradingException(
				"Could not create the ObjectOutputStream!"
			);
		}
	}

	private Student getStudent(final Integer id) throws StudentGradingException {
		final var student = this.students.get(id);
		if (student == null) {
			throw new StudentGradingException(
				id + " is not the ID of any known student!"
			);
		}
		return student;
	}

	@Override
	public void serializeStreamStudent(final int id) throws StudentGradingException {
		if (this.oos == null) {
			throw new StudentGradingException(""
				+ "The ObjectOutputStream must not be null.\n"
				+ "StudentAPI#setSerialStream must be called before this."
			);
		}

		final var student = this.getStudent((Integer) id);

		StudentGradingException.fwd(() -> this.oos.writeObject(student));
	}

	@Override
	public byte[] serializeStudent(final int id) throws StudentGradingException {
		final var student = this.getStudent((Integer) id);
		final var baos = new ByteArrayOutputStream();
		try {
			final var temp_oos = new ObjectOutputStream(baos);
			temp_oos.writeObject(student);
		} catch (Throwable t) {
			throw new StudentGradingException(t);
		}

		return baos.toByteArray();
	}
}
