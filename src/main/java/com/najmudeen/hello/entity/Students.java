package com.najmudeen.hello.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Students {

    @Id
    @Column(name = "st_id", nullable = false, unique = true)
    private String st_id;

    @Column(name = "st_name", nullable = false)
    private String st_name;

    @Column(name = "st_dept", nullable = false)
    private String st_dept;

    @Column(name = "st_contact", nullable = false)
    private String st_contact;

    @Column(name = "gender", nullable = false)
    private String gender;

    // Constructor for easy object creation
    public Students(String st_name, String st_id, String st_dept, String st_contact, String gender) {
        this.st_name = st_name;
        this.st_id = st_id;
        this.st_dept = st_dept;
        this.st_contact = st_contact;
        this.gender = gender;

    }
}
