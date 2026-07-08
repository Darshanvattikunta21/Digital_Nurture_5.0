package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        System.out.println("Student saved: " + savedStudent.getName());
        return savedStudent;
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Total students found: " + students.size());
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        System.out.println(student.isPresent() ? "Student found with id: " + id : "Student not found with id: " + id);
        return student;
    }

    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedStudent.getName());
                    existing.setEmail(updatedStudent.getEmail());
                    existing.setCourse(updatedStudent.getCourse());
                    existing.setAge(updatedStudent.getAge());
                    Student saved = studentRepository.save(existing);
                    System.out.println("Student updated: " + saved.getName());
                    return saved;
                })
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        System.out.println("Student deleted with id: " + id);
    }
}
