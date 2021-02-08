package com.jwtTestTwo.jwtTestTwo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> list = Arrays.asList(new Student(1, "Joe"), new Student(2, "Mike"),
			new Student(3, "Ally"), new Student(4, "Sarah"));

	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentid) {
		return list.stream().filter(x -> x.getStudentId().equals(studentid)).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student :" + studentid + " does not exist"));
	}
}
