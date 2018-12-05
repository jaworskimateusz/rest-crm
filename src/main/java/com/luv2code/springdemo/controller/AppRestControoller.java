package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spring.pojo.Student;
import com.luv2code.springdemo.error.CustomerNotFoundException;

/**
 * 
 *
 * @class only for information
 *
 */
//@RestController
//@RequestMapping("/rest")
public class AppRestControoller {

	private List<Student> students;

	@PostConstruct
	public void loadstudents() {
		students = new ArrayList<>();
		students.add(new Student("Han"));
		students.add(new Student("Dom"));
		students.add(new Student("Joe"));
		students.add(new Student("Danny"));
	}

	@GetMapping("/hello")
	public String sayHallo() {
		return "Hello World!";
	}

	@GetMapping("/students")
	public List<Student> getstudents() {
		return students;
	}

	@GetMapping("/students/{number}")
	public Student getStudentByNumber(@PathVariable int number) {
		if (isStudentExist(number) == false) {
			throw new CustomerNotFoundException("Student was not found");
		}
		return students.get(number);
	}

	private boolean isStudentExist(int number) {
		return (number < 0 || number >= students.size()) ? false : true;
	}
}
