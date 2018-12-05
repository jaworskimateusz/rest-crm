package com.luv2code.springdemo.run;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.spring.pojo.Student;

public class DriverLite {

	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			printStudentData(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void printStudentData(Student student) {
		System.out.println("First name: " + student.getFirstName());
		System.out.println("Last name: " + student.getLastName());
	}
}
