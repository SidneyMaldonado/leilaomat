package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.EmpresaLeilaoBiz;
import com.example.leilao.entities.EmpresaLeilao;
import com.example.leilao.repositories.EmpresaLeilaoRepository;

@RestController
@RequestMapping("empresaleilao")
public class EmpresaLeilaoController {
	
	@Autowired
	EmpresaLeilaoRepository empresaLeilaoRepository;

	@GetMapping("listar")
	public List<EmpresaLeilao> listar() {
		
		return empresaLeilaoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody EmpresaLeilao nEmpresaLeilao) {
		
		EmpresaLeilaoBiz empresaLeilaoBiz = new EmpresaLeilaoBiz(empresaLeilaoRepository);
		
		try {
			
			if(empresaLeilaoBiz.validar(nEmpresaLeilao)) {
				empresaLeilaoRepository.save(nEmpresaLeilao);
				empresaLeilaoRepository.flush();
				empresaLeilaoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			empresaLeilaoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return empresaLeilaoBiz.getMsg();
	}
	
}
