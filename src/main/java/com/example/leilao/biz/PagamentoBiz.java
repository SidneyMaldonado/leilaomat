package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Pagamento;
import com.example.leilao.repositories.PagamentoRepository;

public class PagamentoBiz {
	
	private Mensagem msg;
	private PagamentoRepository pagamentoLeilaoRepository;
	
	public PagamentoBiz(PagamentoRepository pagamentoLeilaoRepository) {
		super();
		this.msg = new Mensagem();
		this.pagamentoLeilaoRepository = pagamentoLeilaoRepository;
	}

	public Boolean validar(Pagamento pagamento) {
		
		Boolean valid = true;
		
		if(pagamento.getDescricao().isEmpty()) {
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

	public PagamentoRepository getPagamentoRepository() {
		return pagamentoLeilaoRepository;
	}

	public void setPagamentoRepository(PagamentoRepository pagamentoLeilaoRepository) {
		this.pagamentoLeilaoRepository = pagamentoLeilaoRepository;
	}
}
