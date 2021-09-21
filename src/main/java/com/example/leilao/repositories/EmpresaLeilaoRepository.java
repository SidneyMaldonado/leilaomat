package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.EmpresaLeilao;

@Repository
public interface EmpresaLeilaoRepository extends JpaRepository<EmpresaLeilao, Integer>{

}
