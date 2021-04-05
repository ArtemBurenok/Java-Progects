package com.example.interview.Models;


import javax.persistence.*;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Manager manager;


    public Planet(){
    }

    public Planet(String name, Manager manager){
        this.name = name;
        this.manager = manager;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
