package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Venda;
import com.example.leilao.repositories.VendaRepository;

public class VendaBiz {
	
	private Mensagem msg;
	private VendaRepository vendaRepository;
	
	public VendaBiz(VendaRepository vendaRepository) {
		super();
		this.msg = new Mensagem();
		this.vendaRepository = vendaRepository;
	}

	public Boolean validar(Venda venda) {
		
		Boolean valid = true;
		
		if(venda.getDescricao().isEmpty()) {
			msg.mensagem.add("A descrição inserida não pode estar em branco");
			valid = false;
		}
		return valid;
	}
	
	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}

	public VendaRepository getVendaRepository() {
		return vendaRepository;
	}

	public void setVendaRepository(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}
}
