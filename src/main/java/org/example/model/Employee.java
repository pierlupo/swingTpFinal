package org.example.model;

import lombok.Data;

import java.util.Date;
@Data
public class Employee {

    private int id;
    private String name;
    private String gender;
    private int age;
    private String bloodGroup;
    private String contactNo;
    private String qualifification;
    private Date startDate;
    private Address address;
    private Image image;

    public Employee(int id, String name, String gender, int age, String bloodGroup, String contactNo, String qualifification, Date startDate, Address address, Image image) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.qualifification = qualifification;
        this.startDate = startDate;
        this.address = address;
        this.image = image;
    }

    public Employee(String name, String gender, int age, String bloodGroup, String contactNo, String qualifification, Date startDate, Address address, Image image) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.qualifification = qualifification;
        this.startDate = startDate;
        this.address = address;
        this.image = image;
    }

    public Employee() {
    }
}
