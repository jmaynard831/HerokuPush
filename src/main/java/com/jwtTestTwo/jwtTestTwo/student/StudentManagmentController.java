package com.jwtTestTwo.jwtTestTwo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagmentController {


	private static final List<Student> list = Arrays.asList(new Student(1, "Joe"), new Student(2, "Mike"),
			new Student(3, "Ally"), new Student(4, "Sarah"));
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return list;
    }

    @PostMapping
   // @PreAuthorize("hasAuthority('student:write')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}