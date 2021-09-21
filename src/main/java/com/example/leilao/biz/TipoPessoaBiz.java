package com.example.leilao.biz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.TipoPessoa;
import com.example.leilao.repositories.TipoPessoaRepository;

public class TipoPessoaBiz {
	
	private Mensagem msg;
	private TipoPessoaRepository tipoPessoaRepository;
	
	public TipoPessoaBiz(TipoPessoaRepository tipoPessoaRepository) {
		super();
		this.msg = new Mensagem();
		this.tipoPessoaRepository = tipoPessoaRepository;
	}

	public Boolean validar(TipoPessoa tipoPessoa) {
		
		Boolean valid = true;
		
		if(tipoPessoa.getNome() == null || tipoPessoa.getNome().length() < 1) {
			msg.mensagem.add("O campo de nome não pode estar vazio");
			valid = false;
		}else if(tipoPessoa.getNome().length() > 50 ) {
			msg.mensagem.add("O nome informado é muito grande");
			valid = false;
		}
		if (tipoPessoa.getEmail() != null && tipoPessoa.getEmail().length() > 0) {
		        String validacao = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		        Pattern pattern = Pattern.compile(validacao, Pattern.CASE_INSENSITIVE);
		        Matcher matcher = pattern.matcher(tipoPessoa.getEmail());
		        if (matcher.matches()) {
		            valid = true;
		        }else {
		        	valid = false;
		        	msg.mensagem.add("O formato de email informado não é válido");
		        }
		    }
		return valid;
	}
	
	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}

	public TipoPessoaRepository getTipoPessoaRepository() {
		return tipoPessoaRepository;
	}

	public void setTipoPessoaRepository(TipoPessoaRepository empresaLeilaoRepository) {
		this.tipoPessoaRepository = empresaLeilaoRepository;
	}
}
