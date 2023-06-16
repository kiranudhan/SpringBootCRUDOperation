package com.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.service.StudentService;

@RestController   //it define class is controller class
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Design a method which save student
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student s = studentService.saveStudent(student);
		return ResponseEntity.ok().body(s);
	}
	
	//Design a method which get student data
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		Student student=studentService.getStudentById(id);
		return ResponseEntity.ok().body(student);
	}
	
	//Design a method for fetch all the records
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> s = studentService.getAllStudent();
		return ResponseEntity.ok().body(s);
	}
	
	//Delete the employee by Id
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudentById(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
	}
	
	//update the employee by id
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,
			@PathVariable("id") Integer id){
		Student s = studentService.updateStudentById(student,id);
		return ResponseEntity.ok().body(s);
	}
}

