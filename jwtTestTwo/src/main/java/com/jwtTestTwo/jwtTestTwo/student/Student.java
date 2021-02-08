package com.jwtTestTwo.jwtTestTwo.student;
public class Student {

    private  Integer studentId;
    private String studentName;

    public Student(Integer studentId,
                   String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Student() {
    	super();
    }
    
    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}