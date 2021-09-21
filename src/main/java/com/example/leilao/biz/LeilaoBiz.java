package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Leilao;
import com.example.leilao.repositories.LeilaoRepository;

public class LeilaoBiz {
	
	private Mensagem msg;
	private LeilaoRepository leilaoRepository;
	
	public LeilaoBiz(LeilaoRepository leilaoRepository) {
		super();
		this.msg = new Mensagem();
		this.leilaoRepository = leilaoRepository;
	}

	public Boolean validar(Leilao leilao) {
		
		Boolean valid = true;
		
		if(leilao.getDescricao().isEmpty()) {
			msg.mensagem.add("A descrição inserida não pode estar em branco");
			valid = false;
		}
		if(leilao.getData().toString().isEmpty()) {
			msg.mensagem.add("A data inserida não pode estar em branco");
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

	public LeilaoRepository getLeilaoRepository() {
		return leilaoRepository;
	}

	public void setLeilaoRepository(LeilaoRepository leilaoRepository) {
		this.leilaoRepository = leilaoRepository;
	}
}
