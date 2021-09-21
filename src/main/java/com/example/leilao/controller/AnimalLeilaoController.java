package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.AnimalLeilaoBiz;
import com.example.leilao.entities.AnimalLeilao;
import com.example.leilao.repositories.AnimalLeilaoRepository;

@RestController
@RequestMapping("animalleilao")
public class AnimalLeilaoController {
	
	@Autowired
	AnimalLeilaoRepository animalLeilaoRepository;

	@GetMapping("listar")
	public List<AnimalLeilao> listar() {
		
		return animalLeilaoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody AnimalLeilao nAnimalLeilao) {
		
		AnimalLeilaoBiz animalLeilaoBiz = new AnimalLeilaoBiz(animalLeilaoRepository);
		
		try {
			
			if(animalLeilaoBiz.validar(nAnimalLeilao)) {
				animalLeilaoRepository.save(nAnimalLeilao);
				animalLeilaoRepository.flush();
				animalLeilaoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			animalLeilaoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return animalLeilaoBiz.getMsg();
	}
	
}
