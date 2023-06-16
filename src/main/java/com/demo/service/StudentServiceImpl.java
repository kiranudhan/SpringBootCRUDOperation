package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	//Repository injected
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		Student s=studentRepository.save(student);
		return s;
	}
	
	@Override
	public Student getStudentById(Integer id) {
		Student student= studentRepository.findById(id);
		return student;
	}
	
	@Override
	public void deleteStudentById(Integer id) {
		Student student=studentRepository.findById(id);
		if(student != null) {
			studentRepository.deleteById(id);
		}
	}

	@Override
	public Student updateStudentById(Student student, Integer id) {
		Student existingUser = studentRepository.findById(id);
		if(student != null) {
			existingUser.setName(student.getName());
			existingUser.setCity(student.getCity());
			
			return saveStudent(existingUser);
		}else {
			return saveStudent(existingUser);
		}
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}
		
	
}
