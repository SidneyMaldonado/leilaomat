package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.TipoPessoaBiz;
import com.example.leilao.entities.TipoPessoa;
import com.example.leilao.repositories.TipoPessoaRepository;

@RestController
@RequestMapping("tipopessoa")
public class TipoPessoaController {
	
	@Autowired
	TipoPessoaRepository empresaLeilaoRepository;

	@GetMapping("listar")
	public List<TipoPessoa> listar() {
		
		return empresaLeilaoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody TipoPessoa nTipoPessoa) {
		
		TipoPessoaBiz empresaLeilaoBiz = new TipoPessoaBiz(empresaLeilaoRepository);
		
		try {
			
			if(empresaLeilaoBiz.validar(nTipoPessoa)) {
				empresaLeilaoRepository.save(nTipoPessoa);
				empresaLeilaoRepository.flush();
				empresaLeilaoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			empresaLeilaoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return empresaLeilaoBiz.getMsg();
	}
	
}
