package com.najmudeen.hello.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.najmudeen.hello.entity.Students;
import com.najmudeen.hello.repository.StudentRepository;

@Service
public class HelloService {

    @Autowired
    StudentRepository studentRepository;

    public List<Students> getStudents() {
        return studentRepository.findAll(); // Return all students
    }

    public Students getRollNumber(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public String addStudent(Students student) {
        studentRepository.save(student);
        return "Student added successfully";
    }

    public String updateStudent(String id, Students updatedStudent) {
        List<Students> studentList = getStudents(); // Fetch data directly inside the service
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSt_id().equals(id)) {
                studentList.set(i, updatedStudent); // Correct update logic
                studentRepository.save(updatedStudent); // Save the updated student
                studentRepository.flush(); // Flush the changes to the database
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }

    public String deleteStudent(String id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id); // Delete the student by ID
            studentRepository.flush(); // Flush the changes to the database
            studentRepository.findAll(); // Fetch the updated list of students
            return "Student deleted successfully";
        }
        return "Student not found";
    }
}