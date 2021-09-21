package com.example.leilao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.entities.TipoPessoa;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Integer>{

}
