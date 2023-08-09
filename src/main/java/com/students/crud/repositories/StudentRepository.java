package com.students.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.crud.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
