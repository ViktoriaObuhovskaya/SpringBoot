package com.example.java.task.service;

import com.example.java.task.entity.Student;
import com.example.java.task.repository.StudentRepository;
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

    public void create(Student student) {
        studentRepository.save(student);
    }

    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> readById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void updateById(Long studentId, Student student) {
        student.setStudentId(studentId);
        studentRepository.save(student);
    }

    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
