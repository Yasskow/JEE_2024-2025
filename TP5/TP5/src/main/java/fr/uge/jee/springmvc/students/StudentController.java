package fr.uge.jee.springmvc.students;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Controller
public class StudentController {
    private final Map<Long, Student> students = Map.of(0l, new Student("Steven", "Ly"),
                                                      1l, new Student("Christophe", "Haidamous"),
                                                      2l, new Student("Yassine", "Benmechich"));

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        var student = students.get(id);
        if (student==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No student with id ("+id+")");
        } else {
            return student;
        }
    }
}