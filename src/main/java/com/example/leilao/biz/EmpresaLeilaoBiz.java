package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.EmpresaLeilao;
import com.example.leilao.repositories.EmpresaLeilaoRepository;

public class EmpresaLeilaoBiz {
	
	private Mensagem msg;
	private EmpresaLeilaoRepository empresaLeilaoRepository;
	
	public EmpresaLeilaoBiz(EmpresaLeilaoRepository empresaLeilaoRepository) {
		super();
		this.msg = new Mensagem();
		this.empresaLeilaoRepository = empresaLeilaoRepository;
	}

	public Boolean validar(EmpresaLeilao empresaLeilao) {
		
		Boolean valid = true;
		
		if(empresaLeilao.getNome().isEmpty()) {
			msg.mensagem.add("O nome não pode ser vazio");
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

	public EmpresaLeilaoRepository getEmpresaLeilaoRepository() {
		return empresaLeilaoRepository;
	}

	public void setEmpresaLeilaoRepository(EmpresaLeilaoRepository empresaLeilaoRepository) {
		this.empresaLeilaoRepository = empresaLeilaoRepository;
	}
}
