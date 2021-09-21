package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.LeilaoBiz;
import com.example.leilao.entities.Leilao;
import com.example.leilao.repositories.LeilaoRepository;

@RestController
@RequestMapping("leilao")
public class LeilaoController {
	
	@Autowired
	LeilaoRepository leilaoRepository;

	@GetMapping("listar")
	public List<Leilao> listar() {
		
		return leilaoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Leilao nLeilao) {
		
		LeilaoBiz leilaoBiz = new LeilaoBiz(leilaoRepository);
		
		try {
			
			if(leilaoBiz.validar(nLeilao)) {
				leilaoRepository.save(nLeilao);
				leilaoRepository.flush();
				leilaoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			leilaoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return leilaoBiz.getMsg();
	}
	
}
