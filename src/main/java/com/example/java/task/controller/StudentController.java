package com.example.java.task.controller;

import com.example.java.task.entity.Student;
import com.example.java.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.readAll();
    }

    @GetMapping(path = "{studentId}")
    public Student getById(@PathVariable("studentId") Long studentId) {
        return studentService.readById(studentId).orElse(null);
    }

    @PutMapping(path = "{studentId}")
    public void update(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        studentService.updateById(studentId, student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteById(@PathVariable("studentId") Long studentId) {
        studentService.deleteById(studentId);
    }
}
