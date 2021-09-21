package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.CompradorBiz;
import com.example.leilao.entities.Comprador;
import com.example.leilao.repositories.CompradorRepository;

@RestController
@RequestMapping("comprador")
public class CompradorController {
	
	@Autowired
	CompradorRepository compradorRepository;

	@GetMapping("listar")
	public List<Comprador> listar() {
		
		return compradorRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Comprador nComprador) {
		
		CompradorBiz compradorBiz = new CompradorBiz(compradorRepository);
		
		try {
			
			if(compradorBiz.validar(nComprador)) {
				compradorRepository.save(nComprador);
				compradorRepository.flush();
				compradorBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			compradorBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return compradorBiz.getMsg();
	}
	
}
