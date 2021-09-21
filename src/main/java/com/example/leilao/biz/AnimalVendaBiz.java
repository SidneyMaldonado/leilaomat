package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.AnimalVenda;
import com.example.leilao.repositories.AnimalVendaRepository;

public class AnimalVendaBiz {
	
	private Mensagem msg;
	private AnimalVendaRepository animalVendaRepository;
	
	public AnimalVendaBiz(AnimalVendaRepository animalVendaRepository) {
		super();
		this.msg = new Mensagem();
		this.animalVendaRepository = animalVendaRepository;
	}

	public Boolean validar(AnimalVenda animalVenda) {
		
		Boolean valid = true;
		
		if(animalVenda.getIdAnimal() < 1 || animalVenda.getIdVenda() == null) {
			msg.mensagem.add("O campo de id animal nao pode ser menor que 1 ou nulo");
			valid = false;
		}
		if(animalVenda.getIdVenda() < 1 || animalVenda.getIdVenda() == null){
			msg.mensagem.add("O campo de id animal nao pode ser menor que 1 ou nulo");
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

	public AnimalVendaRepository getAnimalVendaRepository() {
		return animalVendaRepository;
	}

	public void setAnimalVendaRepository(AnimalVendaRepository animalVendaRepository) {
		this.animalVendaRepository = animalVendaRepository;
	}
}
