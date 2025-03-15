package com.najmudeen.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.najmudeen.hello.entity.Students;
import com.najmudeen.hello.service.HelloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

//@CrossOrigin(origins = "http://localhost:3000") // Allow requests from specific origins
@RestController
@RequestMapping("/SpringBoot/api")
public class HelloController {

    @Autowired
    HelloService service;

    @DeleteMapping("/students/{id}")
    public String deleteById(@PathVariable("id") String id) {
        return service.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public String putMethodName(@PathVariable("id") String id, @RequestBody Students students) {
        return service.Update(id, students);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Students student) {
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<Students> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/students/{id}")
    public Students getRollNumber(@PathVariable("id") String id) {
        return service.getRollNumber(id);
    }

}