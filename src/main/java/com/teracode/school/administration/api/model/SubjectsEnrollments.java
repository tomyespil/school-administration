package com.teracode.school.administration.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subjects_enrollments")
public class SubjectsEnrollments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_subject_enrollment;
	
	@Column(nullable = false, name = "subject_id")
	private int subjectId;
	
	@Column(nullable = false, name = "student_id")
	private int studentId;
	
	@Column(nullable = false, name = "enrollment_date")
	private Date enrollmentDate;
	
	@ManyToOne
    @JoinColumn(name="subject_id", nullable = true, insertable = false, updatable = false)
	private Subject subject;

	public int getId_subject_enrollment() {
		return id_subject_enrollment;
	}

	public void setId_subject_enrollment(int id_subject_enrollment) {
		this.id_subject_enrollment = id_subject_enrollment;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
