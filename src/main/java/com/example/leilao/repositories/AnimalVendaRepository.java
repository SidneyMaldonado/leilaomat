package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.AnimalVenda;

@Repository
public interface AnimalVendaRepository extends JpaRepository<AnimalVenda, Integer>{

}
