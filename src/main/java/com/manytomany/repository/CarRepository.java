package com.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.manytomany.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
