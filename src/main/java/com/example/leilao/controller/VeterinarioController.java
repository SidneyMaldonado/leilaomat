package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.VeterinarioBiz;
import com.example.leilao.entities.Veterinario;
import com.example.leilao.repositories.VeterinarioRepository;

@RestController
@RequestMapping("veterinario")
public class VeterinarioController {
	
	@Autowired
	VeterinarioRepository veterinarioRepository;

	@GetMapping("listar")
	public List<Veterinario> listar() {
		
		return veterinarioRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Veterinario nVeterinario) {
		
		VeterinarioBiz veterinarioBiz = new VeterinarioBiz(veterinarioRepository);
		
		try {
			
			if(veterinarioBiz.validar(nVeterinario)) {
				veterinarioRepository.save(nVeterinario);
				veterinarioRepository.flush();
				veterinarioBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			veterinarioBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return veterinarioBiz.getMsg();
	}
	
}
