package ru.aston.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.aston.model.Log;

import java.util.Collection;

@Repository
public class LogRepository {

    final SessionFactory sessionFactory;

    public LogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void createLog(Log log){
        Session session = sessionFactory.getCurrentSession();
        session.save(log);
    }

    @Transactional
    public Log removeLog(Long id){
        Session session = sessionFactory.getCurrentSession();
        Log log = session.get(Log.class, id);
        if (log == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Log not found");
        }
        session.delete(log);
        return log;
    }

    @Transactional
    public Collection<Log> getLogsByStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select l from Log l where l.student.id = ?1", Log.class).setParameter(1, id).getResultList();
    }

}
