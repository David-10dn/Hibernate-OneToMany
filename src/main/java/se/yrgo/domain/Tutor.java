package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tutorId;
    private String name;
    private int salary;
    @OneToMany
    @JoinColumn(name = "TUTOR_FK")
    private List<Student> teachingGroup;

    public Tutor() {
    }

    public Tutor(int id, String tutorId, String name, int salary, List<Student> teachingGroup) {
        this.id = id;
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup() {

        List<Student> unmodifiable = this.teachingGroup;
        return unmodifiable;
    }

}