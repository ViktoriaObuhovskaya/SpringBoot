package com.example.java.task.config;

import com.example.java.task.entity.Student;
import com.example.java.task.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        return args -> {
            Student student1 = new Student("Petr", "Petrov", LocalDate.of(1985, Month.APRIL, 9));
            Student student2 = new Student("Alexandra", "Petrova", LocalDate.of(1983, Month.JANUARY, 6));
            Student student3 = new Student("Sergei", "Sergeev", LocalDate.of(1986, Month.AUGUST, 1));
            Student student4 = new Student("Svetlana", "Ivanova", LocalDate.of(1986, Month.JUNE, 5));
            Student student5 = new Student("Sergei", "Ivanov", LocalDate.of(1987, Month.SEPTEMBER, 7));

            studentRepository.saveAll(List.of(student1, student2, student3, student4, student5));
        };
    }
}
