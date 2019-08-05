package edu.mum.cs.cs425.eRegistrar.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.repository.StudentRepository;
import edu.mum.cs.cs425.eRegistrar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Iterable<Student> getAllStudents() {
//      return ((List<Student>)repository.findAll())
//      .stream()
//      .sorted(Comparator.comparing(Student::getFirstName))
//      .collect(Collectors.toList());
		return repository.findAll(Sort.by("firstName"));
	}

	@Override
	public Page<Student> getAllStudentsPaged(int pageNo) {
		return repository.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		return repository.findById(studentId).orElse(null);
	}

	@Override
	public void deleteStudentById(Long studentId) {
		repository.deleteById(studentId);		
	}
	
	@Override
    public Optional<Student> findByStudentNumber(Long studentId, String studentNumber) {
		if(studentId == 0) {//
			 return repository.findStudentByStudentNumber(studentNumber);
		}
		else {
			Optional<Student> stu = repository.findAll()
					 .stream()
					 .filter(s -> s.getStudentNumber().equals(studentNumber) && s.getStudentId() != studentId)
					 .findAny();
			return stu;
		}
			
		
    }
	
}
