package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.AnimalVendaBiz;
import com.example.leilao.entities.AnimalVenda;
import com.example.leilao.repositories.AnimalVendaRepository;

@RestController
@RequestMapping("animalvenda")
public class AnimalVendaController {
	
	@Autowired
	AnimalVendaRepository animalVendaRepository;

	@GetMapping("listar")
	public List<AnimalVenda> listar() {
		
		return animalVendaRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody AnimalVenda nAnimalVenda) {
		
		AnimalVendaBiz animalVendaBiz = new AnimalVendaBiz(animalVendaRepository);
		
		try {
			
			if(animalVendaBiz.validar(nAnimalVenda)) {
				animalVendaRepository.save(nAnimalVenda);
				animalVendaRepository.flush();
				animalVendaBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			animalVendaBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return animalVendaBiz.getMsg();
	}
	
}
