package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.AnimalBiz;
import com.example.leilao.entities.Animal;
import com.example.leilao.repositories.AnimalRepository;

@RestController
@RequestMapping("animal")
public class AnimalController {
	
	// meu comentario do projeto - Sidney
	
	@Autowired
	AnimalRepository animalRepository;

	@GetMapping("listar")
	public List<Animal> listar() {
		
		return animalRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody @Validated Animal nAnimal) {
		
		AnimalBiz animalBiz = new AnimalBiz(animalRepository);
		
		try {
			
			if(animalBiz.validar(nAnimal)) {
				animalRepository.save(nAnimal);
				animalRepository.flush();
				animalBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			animalBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return animalBiz.getMsg();
	}
	
}
