package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Veterinario;
import com.example.leilao.repositories.VeterinarioRepository;

public class VeterinarioBiz {
	
	private Mensagem msg;
	private VeterinarioRepository veterinarioRepository;
	
	public VeterinarioBiz(VeterinarioRepository veterinarioRepository) {
		super();
		this.msg = new Mensagem();
		this.veterinarioRepository = veterinarioRepository;
	}

	public Boolean validar(Veterinario veterinario) {
		
		Boolean valid = true;
		
		if(veterinario.getCrmv().isEmpty())  {
			msg.mensagem.add("O CRMV inserido não pode estar em branco");
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

	public VeterinarioRepository getVeterinarioRepository() {
		return veterinarioRepository;
	}

	public void setVeterinarioRepository(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}
}
