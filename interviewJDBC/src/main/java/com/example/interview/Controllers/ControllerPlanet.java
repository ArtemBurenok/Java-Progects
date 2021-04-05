package com.example.interview.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class ControllerPlanet {
    private String userName = "postgres";
    private String password = "1234";
    private String connectionURL = "jdbc:postgresql://localhost:5432/test";

    @GetMapping("/planet")
    public String Planet(){
        return "planet";
    }

    @PostMapping("/planet")
    public String PlanetAdd(@RequestParam String namePlanet, @RequestParam int manager, Model model) throws ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL,
                userName, password);
             Statement statement = connection.createStatement()){
            String name = namePlanet;
            int manager_id = manager;
            statement.executeUpdate("INSERT INTO planet(name, manager_id) VALUES (name, manager_id)");

        }catch (SQLException trowables){
            trowables.printStackTrace();
        }
        return "/planet";
    }
}
