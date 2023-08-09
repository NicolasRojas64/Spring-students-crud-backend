package com.students.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.crud.exceptions.ResourceNotFoundException;
import com.students.crud.models.Student;
import com.students.crud.repositories.StudentRepository;

@RestController
@RequestMapping("/students-crud")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/list")
	public List<Student> listStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("students{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = studentRepository.findById(id)
						  .orElseThrow(() -> new ResourceNotFoundException("El estudiante no está registrado"));
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent){
		Student student = studentRepository.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("El estudiante no está registrado"));
		student.setName(updatedStudent.getName());
		student.setLastName(updatedStudent.getLastName());
		student.setEmail(updatedStudent.getEmail());
		student = studentRepository.save(student);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("students/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentRepository.deleteById(id);
		
	}
}
