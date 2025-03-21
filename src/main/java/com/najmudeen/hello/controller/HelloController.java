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
    HelloService helloService;

    @DeleteMapping("/students/{id}")
    public String deleteById(@PathVariable String id) {
       return helloService.deleteStudent(id); // Fetch the list of students
    }

    @PutMapping("/students/{id}")
    public String putMethodName(@PathVariable("id") String id, @RequestBody Students students) {
        return helloService.updateStudent(id, students);  //  No need to pass studentList here
    }
    

    @PostMapping("/students")
    public String addStudent(@RequestBody Students students) {
        return helloService.addStudent(students);
    }

    @GetMapping("/students")
    public List<Students> getStudents() {
        return helloService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Students getRollNumber(@PathVariable("id") String st_id) {
        return helloService.getRollNumber(st_id);
    }
}