package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.VendaBiz;
import com.example.leilao.entities.Venda;
import com.example.leilao.repositories.VendaRepository;

@RestController
@RequestMapping("venda")
public class VendaController {
	
	@Autowired
	VendaRepository vendaRepository;

	@GetMapping("listar")
	public List<Venda> listar() {
		
		return vendaRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Venda nVenda) {
		
		VendaBiz vendaBiz = new VendaBiz(vendaRepository);
		
		try {
			
			if(vendaBiz.validar(nVenda)) {
				vendaRepository.save(nVenda);
				vendaRepository.flush();
				vendaBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			vendaBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return vendaBiz.getMsg();
	}
	
}
