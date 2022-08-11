package ru.aston.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.aston.model.Log;
import ru.aston.services.LogService;

import java.util.Collection;

@RestController
@RequestMapping("${base.endpoint.path.log}")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping()
    public ResponseEntity<Log> setStudentService(@RequestBody Log log, @RequestParam(name = "student_id") Long studentId) {
        logService.creatLog(log, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(log);
    }

    @GetMapping("/get_logs_by_student/{id}")
    public Collection<Log> getAllStudent(@PathVariable Long id) {
        if (id == null || id < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be positive and not null");
        }
        return logService.getLogsByStudent(id);
    }

    @DeleteMapping("/{id}")
    public Log removeStudent(@PathVariable Long id) {
        if (id == null || id < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be positive and not null");
        }
        return logService.removeLog(id);
    }

}
