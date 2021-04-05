package com.example.interview.Repo;

import com.example.interview.Models.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
}
