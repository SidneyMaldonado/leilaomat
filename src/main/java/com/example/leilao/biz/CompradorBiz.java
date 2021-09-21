package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Comprador;
import com.example.leilao.repositories.CompradorRepository;

public class CompradorBiz {
	
	private Mensagem msg;
	private CompradorRepository compradorRepository;
	
	public CompradorBiz(CompradorRepository compradorRepository) {
		super();
		this.msg = new Mensagem();
		this.compradorRepository = compradorRepository;
	}

	public Boolean validar(Comprador comprador) {
		
		Boolean valid = true;
		
		if(comprador.getCpf().isEmpty() || comprador.getCpf().length() != 11)  {
			msg.mensagem.add("O cpf inserido não pode estar em branco ou ser diferente de 11 digitos");
			valid = false;
		}
		if(comprador.getLance() < 0) {
			msg.mensagem.add("O lance não pode ser menor que 0");
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

	public CompradorRepository getCompradorRepository() {
		return compradorRepository;
	}

	public void setCompradorRepository(CompradorRepository compradorRepository) {
		this.compradorRepository = compradorRepository;
	}
}
