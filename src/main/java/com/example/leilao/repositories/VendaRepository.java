package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
