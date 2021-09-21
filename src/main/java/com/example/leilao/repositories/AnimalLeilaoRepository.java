package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.AnimalLeilao;

@Repository
public interface AnimalLeilaoRepository extends JpaRepository<AnimalLeilao, Integer>{

}
