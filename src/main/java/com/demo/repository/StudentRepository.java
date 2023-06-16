package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Serializable>{
	public Student findById(Integer id);
}
