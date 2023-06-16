package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	public Student getStudentById(Integer id);
	public List<Student> getAllStudent();
	public void deleteStudentById(Integer id); 
	public Student updateStudentById(Student student,Integer id);
}
