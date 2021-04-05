package com.example.interview.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

@org.springframework.stereotype.Controller
public class Controller {
    private String userName = "postgres";
    private String password = "1234";
    private String connectionURL = "jdbc:postgresql://localhost:5432/test";

    @GetMapping("/manager")
    public String Manager(Model model) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL,
                userName, password);
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT name FROM manager ORDER BY age LIMIT 10");

            model.addAttribute("resultSet", resultSet);
        }catch (SQLException trowables){
            trowables.printStackTrace();
        }
        return "manager";
    }

    @PostMapping("/manager")
    public String ManagerAdd(@RequestParam String name,@RequestParam int age, Model model) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL,
                userName, password);
             Statement statement = connection.createStatement()){
            String nameManager = name;
            int ageManager = age;
            statement.executeUpdate("INSERT INTO manager(name, ade) VALUES (nameManager, ageManager)");

            ResultSet resultSet = statement.executeQuery("SELECT name FROM manager ORDER BY ade LIMIT 10");
            model.addAttribute("resultSet", resultSet);

        }catch (SQLException trowables){
            trowables.printStackTrace();
        }
        return "manager";
    }

}
