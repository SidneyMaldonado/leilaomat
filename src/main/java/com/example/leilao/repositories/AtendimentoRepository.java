package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{

}
