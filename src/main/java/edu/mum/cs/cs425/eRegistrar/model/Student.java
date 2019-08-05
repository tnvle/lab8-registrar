package edu.mum.cs.cs425.eRegistrar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.cs.cs425.eRegistrar.model.validators.UniqueStudentNumber;



@Entity
@Table(name = "students")
@UniqueStudentNumber
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;	
	
//	@UniqueStudentNumber
	@NotBlank(message = "* Student Number is required")
	@Column(nullable = false, unique = true)
	private String studentNumber;
	
	@NotBlank(message = "* First Name is required")
	@Column(nullable = false)
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message = "* Last Name is required")
	@Column(nullable = false)
	private String lastName;
	
	private Double cgpa;
	
	@NotNull(message = "* Enrollment Date is required")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;
	
	@NotNull(message = "* Is International is required")
	@Column(nullable = false)
//	@Type(type="yes_no")
	private boolean isInternational;

	public Student() {
		
	}
	public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa,
			LocalDate enrollmentDate, boolean isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(boolean isInternational) {
		this.isInternational = isInternational;
	}		

}
