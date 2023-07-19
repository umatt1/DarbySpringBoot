package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sophia", "Ramirez"));
        theStudents.add(new Student("Matthew", "Burkhard"));
        theStudents.add(new Student("Mario", "Luigi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id >= theStudents.size() || id < 0) {
            throw new StudentNotFoundException("Could not find id " + id);
        }

        return theStudents.get(id);
    }
}
