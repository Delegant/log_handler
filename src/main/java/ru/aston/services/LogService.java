package ru.aston.services;

import ru.aston.model.Log;

import java.util.Collection;

public interface LogService {

    void creatLog(Log log, Long studentId);

    Collection<Log> getLogsByStudent(Long id);

    Log removeLog(Long id);

}
