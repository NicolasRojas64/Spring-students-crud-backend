package com.students.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.crud.models.Student;
import com.students.crud.repositories.StudentRepository;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> listStudents(){
		return studentRepository.findAll();
	}
	
}
