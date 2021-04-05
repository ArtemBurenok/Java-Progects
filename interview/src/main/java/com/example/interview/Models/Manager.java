package com.example.interview.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int Age;
    @OneToMany
    private List<Planet> planets;

    public Manager(){}

    public Manager(String name, int age){
        this.name = name;
        this.Age = age;
    }


    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
