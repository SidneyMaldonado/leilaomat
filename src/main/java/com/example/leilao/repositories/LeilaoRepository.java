package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.Leilao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer>{

}
