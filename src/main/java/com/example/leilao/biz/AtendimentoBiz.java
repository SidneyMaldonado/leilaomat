package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Atendimento;
import com.example.leilao.repositories.AtendimentoRepository;

public class AtendimentoBiz {
	
	private Mensagem msg;
	private AtendimentoRepository atendimentoRepository;
	
	public AtendimentoBiz(AtendimentoRepository atendimentoRepository) {
		super();
		this.msg = new Mensagem();
		this.atendimentoRepository = atendimentoRepository;
	}

	public Boolean validar(Atendimento atendimento) {
		
		Boolean valid = true;
		
		if(atendimento.getDescricao().isEmpty()) {
			msg.mensagem.add("O nome inserido não pode estar em branco");
			valid = false;
		}
		if(atendimento.getData().toString().isEmpty()) {
			msg.mensagem.add("O nome inserido não pode estar em branco");
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

	public AtendimentoRepository getAtendimentoRepository() {
		return atendimentoRepository;
	}

	public void setAtendimentoRepository(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}
	
	
	
	
	
}
