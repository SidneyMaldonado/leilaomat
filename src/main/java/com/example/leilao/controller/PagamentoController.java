package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.PagamentoBiz;
import com.example.leilao.entities.Pagamento;
import com.example.leilao.repositories.PagamentoRepository;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
	
	@Autowired
	PagamentoRepository pagamentoRepository;

	@GetMapping("listar")
	public List<Pagamento> listar() {
		
		return pagamentoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Pagamento nPagamento) {
		
		PagamentoBiz pagamentoBiz = new PagamentoBiz(pagamentoRepository);
		
		try {
			
			if(pagamentoBiz.validar(nPagamento)) {
				pagamentoRepository.save(nPagamento);
				pagamentoRepository.flush();
				pagamentoBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			pagamentoBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return pagamentoBiz.getMsg();
	}
}
