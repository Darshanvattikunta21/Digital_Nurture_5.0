package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private final StudentService studentService;

    @Autowired
    public MainApp(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Maven Project - Spring Boot with JPA Demo ===");
        System.out.println("--- Creating Students ---");

        Student student1 = new Student("Rahul", "rahul@test.com", "Java", 20);
        Student student2 = new Student("Priya", "priya@test.com", "React", 21);
        Student student3 = new Student("Sam", "sam@test.com", "Spring", 22);
        Student student4 = new Student("Anita", "anita@test.com", "Java", 20);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        studentService.saveStudent(student3);
        studentService.saveStudent(student4);

        System.out.println("--- All Students ---");
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);

        System.out.println("--- Students by Course: Java ---");
        List<Student> javaStudents = studentService.getStudentsByCourse("Java");
        javaStudents.forEach(System.out::println);

        System.out.println("--- Update Student ID 1 ---");
        Student updatedStudent = new Student("Rahul", "rahul.updated@test.com", "Java", 25);
        studentService.updateStudent(1L, updatedStudent);

        System.out.println("--- Delete Student ID 4 ---");
        studentService.deleteStudent(4L);

        System.out.println("--- Final Student List ---");
        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("=== Demo Completed ===");
    }
}
