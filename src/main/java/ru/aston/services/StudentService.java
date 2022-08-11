package ru.aston.services;

import org.springframework.stereotype.Service;
import ru.aston.model.Student;

import java.util.Collection;

@Service
public interface StudentService {

    void createStudent(Student student);

    Collection<Student> getStudents();

    Student removeStudent(Long id);

    Student getStudent(Long id);
}
