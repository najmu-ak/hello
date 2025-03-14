package com.najmudeen.hello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.najmudeen.hello.entity.Students;

@Service
public class HelloService {

    public String test1() {
        return "Hello World";
    }

    public String test2() {
        return "Hello World 2";
    }

     List<Students> students = new ArrayList<>(
        Arrays.asList(
            new Students("Najmudeen", "101", "CSE"),
            new Students("Ali", "102", "ECE"),
            new Students("Deen", "103", "EEE"),
            new Students("Ak", "104", "MECH")
        )
    );
public List<Students> getStudents(){
        return students;
    }

    public Students getRollNumber(String st_id){
        int index = 0;
        for(int i=0; i<students.size(); i++){
            if(students.get(i).getSt_id() == st_id){
                index = i;
            }
        }
        return students.get(index);
    }

    public String addStudent(Students student) {
        students.add(student);
        return "Student added successfully";
    }

    public String updating(Students student) {
            int index = 0;
            for(int i=0; i<students.size(); i++){
                if(students.get(i).getSt_id() == (student.getSt_id())){
                    index = i;
                    break;
                }
            }
        students.set(index, student);
        return "Student updated successfully";
    }

}