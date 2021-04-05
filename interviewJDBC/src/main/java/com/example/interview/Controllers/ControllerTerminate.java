package com.example.interview.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class ControllerTerminate {
    private String userName = "postgres";
    private String password = "1234";
    private String connectionURL = "jdbc:postgresql://localhost:5432/test";

    @PostMapping("/planet/terminate")
    public String terminatePlanet(@RequestParam Long idPlanet) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL,
                userName, password);
             Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM planet WHERE id = idPlanet");

        }catch (SQLException trowables){
            trowables.printStackTrace();
        }
        return "/manager";
    }

    @GetMapping("/planet/terminate")
    public String terminate(){
        return "terminate";
    }
}
