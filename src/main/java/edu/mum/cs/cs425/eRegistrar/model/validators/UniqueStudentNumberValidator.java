package edu.mum.cs.cs425.eRegistrar.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.service.StudentService;


public class UniqueStudentNumberValidator implements ConstraintValidator<UniqueStudentNumber, Student>{

	private StudentService studentService;

    public UniqueStudentNumberValidator() {
    }

    @Autowired
    public UniqueStudentNumberValidator(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void initialize(UniqueStudentNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext context) {
        boolean valid;
        long studentId = student.getStudentId();
        String studentNumber = student.getStudentNumber();
        if(studentService != null) {
            valid = (studentNumber != null && !studentService.findByStudentNumber(studentId, studentNumber).isPresent());
        } else {
            valid = true;
        }
        return valid;
    }
}
