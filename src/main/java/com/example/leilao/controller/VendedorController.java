package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.Mensagem;
import com.example.leilao.biz.VendedorBiz;
import com.example.leilao.entities.Vendedor;
import com.example.leilao.repositories.VendedorRepository;

@RestController
@RequestMapping("vendedor")
public class VendedorController {
	
	@Autowired
	VendedorRepository vendedorRepository;

	@GetMapping("listar")
	public List<Vendedor> listar() {
		
		return vendedorRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Vendedor nVendedor) {
		
		VendedorBiz vendedorBiz = new VendedorBiz(vendedorRepository);
		
		try {
			
			if(vendedorBiz.validar(nVendedor)) {
				vendedorRepository.save(nVendedor);
				vendedorRepository.flush();
				vendedorBiz.getMsg().mensagem.add("ok");
			}	
			
		} catch(Exception e) {
			vendedorBiz.getMsg().mensagem.add("Erro ao incluir: "+ e.getMessage());
		}
		
		return vendedorBiz.getMsg();
	}
	
}
