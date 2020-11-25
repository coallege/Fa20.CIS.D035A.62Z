package driver;

import impl.*;
import adapter.*;
import exception.*;

import java.io.*;
import java.util.*;

import static java.lang.System.*;


interface Driver3 {
	static void main(final String[] args) throws StudentGradingException {
		@SuppressWarnings("rawtypes")
		final IStudentAPI API = new StudentAPI();
		API.readInput();

		out.println("List of students:");
		for (final var id : API.getStudentIds()) {
			out.println("Student #" + id);
		}

		@SuppressWarnings("unchecked")
		final Set<Integer> student_ids = API.getStudentIds();

		try (final var fos = new FileOutputStream("driver.Driver3.students.ser")) {
			API.setSerialStream(fos);
			for (final var id : student_ids) {
				API.serializeStreamStudent(id);
			}
		} catch (Throwable t) {
			return;
		}
	}
}
