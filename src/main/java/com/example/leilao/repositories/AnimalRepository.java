package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
