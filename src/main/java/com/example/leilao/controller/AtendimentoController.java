package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.AtendimentoBiz;
import com.example.leilao.entities.Atendimento;
import com.example.leilao.repositories.AtendimentoRepository;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {
	
	@Autowired
	AtendimentoRepository atendimentoRepository;

	@GetMapping("listar")
	public List<Atendimento> listar() {
		
		return atendimentoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Atendimento nAtendimento) {
		
		AtendimentoBiz atendimentoBiz = new AtendimentoBiz(atendimentoRepository);
		
		try {
			
			if(atendimentoBiz.validar(nAtendimento)) {
				atendimentoRepository.save(nAtendimento);
				atendimentoRepository.flush();
				atendimentoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			atendimentoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return atendimentoBiz.getMsg();
	}
	
}
