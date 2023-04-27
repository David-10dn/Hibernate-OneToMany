package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", enrollmentID='" + enrollmentID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}