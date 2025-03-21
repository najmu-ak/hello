package com.najmudeen.hello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.najmudeen.hello.entity.Students;
import com.najmudeen.hello.repository.StudentRepository;

@Service
public class HelloService {

    @Autowired
    StudentRepository studentRepository;

    // List<Students> students = new ArrayList<>(
    //         Arrays.asList(
    //                 new Students("Najmudeen", "101", "CSE"),
    //                 new Students("Ali", "102", "ECE"),
    //                 new Students("Deen", "103", "EEE"),
    //                 new Students("Ak", "104", "MECH")));

    public List<Students> getStudents() {
        return studentRepository.findAll(); // Return all students 
    }


    public Students getRollNumber(String id) {
        return studentRepository.findById(id).orElse(null); 
    }
    // public Students getRollNumber(String id) {
    //     for (Students student : Students) {
    //         if (student.getSt_id().equals(id)) {
    //             return  Students; // Return the found student
    //         }
    //     }

    //     return "Student not found"; // Return the first student if no student found
    // }

    public String addStudent(Students student) {
        studentRepository.save(student);
        return "Student added successfully";
    }

    public String updateStudent(String id, Students updatedStudent) {
        List<Students> studentList = getStudents();  // Fetch data directly inside the service
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSt_id().equals(id)) {
                studentList.set(i, updatedStudent); //  Correct update logic
                studentRepository.save(updatedStudent); // Save the updated student
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }
    
    

    // public String deleteStudent(String st_id) {
    //     for (int i = 0; i < students.size(); i++) {
    //         if (students.get(i).getSt_id().equals(st_id)) {
    //             students.remove(i); // Remove the student record
    //         }
    //     }
    //     return "Student deleted successfully";

    // }
}