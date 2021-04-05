package com.example.interview.Controllers;

import com.example.interview.Models.Manager;
import com.example.interview.Models.Planet;
import com.example.interview.Repo.ManagerRepository;
import com.example.interview.Repo.PlanetRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping("/manager")
    public String Manager(){
        return "manager";
    }

    @PostMapping("/manager")
    public String ManagerAdd(@RequestParam String name,@RequestParam int age, Model model){
        Manager manager = new Manager(name, age);
        managerRepository.save(manager);
        return "manager";
    }

    @GetMapping("/planet")
    public String Planet(){
        return "planet";
    }

    @PostMapping("/planet")
    public String PlanetAdd(@RequestParam String namePlanet, @RequestParam Manager manager, Model model){
        Planet planet = new Planet(namePlanet, manager);
        planetRepository.save(planet);
        return "/planet";
    }

    @PostMapping("/planet/terminate")
    public String terminatePlanet(@RequestParam Long idPlanet){
        planetRepository.deleteById(idPlanet);
        return "/manager";
    }

    @GetMapping("/planet/terminate")
    public String terminate(){
        return "terminate";
    }

}
