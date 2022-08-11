package ru.aston.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.aston.model.Student;

import java.util.Collection;

@Repository
public class StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Collection<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Transactional
    public void createStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Transactional
    public Student removeStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = getStudent(id);
        session.delete(student);

        return student;
    }

    @Transactional
    public Student getStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);

        if (student == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found");
        }
            return student;

    }
}
