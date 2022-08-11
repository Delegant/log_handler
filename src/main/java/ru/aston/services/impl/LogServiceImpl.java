package ru.aston.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.model.Log;
import ru.aston.model.Student;
import ru.aston.repository.LogRepository;
import ru.aston.services.LogService;
import ru.aston.services.StudentService;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final StudentService studentService;

    public LogServiceImpl(LogRepository logRepository, StudentService studentServiceImpl) {
        this.logRepository = logRepository;
        this.studentService = studentServiceImpl;
    }

    @Override
    public void creatLog(Log log, Long student_id) {
        Student student = studentService.getStudent(student_id);
        log.setDataTime(LocalDateTime.now());
        log.setStudent(student);
        logRepository.createLog(log);
    }

    @Override
    public Collection<Log> getLogsByStudent(Long id) {
        Student student = studentService.getStudent(id);
        return logRepository.getLogsByStudent(student.getId());
    }

    @Override
    public Log removeLog(Long id) {
        return logRepository.removeLog(id);
    }
}
