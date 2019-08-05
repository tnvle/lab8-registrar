package edu.mum.cs.cs425.eRegistrar.service;

import java.util.Optional;

import org.springframework.data.domain.Page;


import edu.mum.cs.cs425.eRegistrar.model.Student;

public interface StudentService {
	
	public abstract Iterable<Student> getAllStudents();
	public abstract Page<Student> getAllStudentsPaged(int pageNo);
	public abstract Student saveStudent(Student student);
	public abstract Student getStudentById(Long studentId);
	public abstract void deleteStudentById(Long studentId);
	public abstract Optional<Student> findByStudentNumber(Long studentId, String studentNumber);
}
