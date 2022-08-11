package ru.aston.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.aston.model.Student;
import ru.aston.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("${base.endpoint.path.student}")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> setStudentService(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/get_all")
    public Collection<Student> getAllStudent() {
        return studentService.getStudents();
    }

    @DeleteMapping("/{id}")
    public Student removeStudent(@PathVariable Long id){
        if (id == null || id < 0) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be positive and not null");
        }
        return studentService.removeStudent(id);
    }

}
