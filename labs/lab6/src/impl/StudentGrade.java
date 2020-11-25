package impl;

import adapter.*;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class StudentGrade extends IStudentGrade implements Serializable {
	protected final Student student;
	protected final Statistics statistics;

	StudentGrade(final Student student, final Statistics statistics) {
		this.student = student;
		this.statistics = statistics;
	}
}
