package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@RestController
@RequestMapping(value="/rest/student")
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@PostMapping
	@RequestMapping(value="/add")
	public String addStudent(@RequestBody Student student) {
		repo.save(student);
		Scanner sc=new Scanner(System.in);
		return "sussess";
	}
	
	@GetMapping
	@RequestMapping(value="/get")
	public List<Student> getStudents(){
		
		List<Student> students=new ArrayList<>();
		students=repo.findAll();
		return students;
	}

}
