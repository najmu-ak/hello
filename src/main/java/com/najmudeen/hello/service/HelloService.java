package com.najmudeen.hello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.najmudeen.hello.entity.Students;

@Service
public class HelloService {

    List<Students> students = new ArrayList<>(
            Arrays.asList(
                    new Students("Najmudeen", "101", "CSE"),
                    new Students("Ali", "102", "ECE"),
                    new Students("Deen", "103", "EEE"),
                    new Students("Ak", "104", "MECH")));

    public List<Students> getStudents() {
        return students;
    }

    public Students getRollNumber(String st_id) {
        for (Students student : students) {
            if (student.getSt_id().equals(st_id)) {
                return student; // Return the found student
            }
        }

        return students.get(0); // Return the first student if no student found
    }

    public String addStudent(Students student) {
        students.add(student);
        return "Student added successfully";
    }

    public String Update(String st_id, Students updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSt_id().equals(st_id)) {
                students.set(i, updatedStudent); // Update the student record
            }
        }
        return "Student updated successfully";
    }

    public String deleteStudent(String st_id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSt_id().equals(st_id)) {
                students.remove(i); // Remove the student record
            }
        }
        return "Student deleted successfully";

    }
}