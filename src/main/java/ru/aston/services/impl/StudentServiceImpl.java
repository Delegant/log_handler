package ru.aston.services.impl;

import org.springframework.stereotype.Service;
import ru.aston.model.Student;
import ru.aston.repository.StudentRepository;
import ru.aston.services.StudentService;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    final
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    @Override
    public Collection<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public Student removeStudent(Long id) {
        return studentRepository.removeStudent(id);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getStudent(id);
    }
}
