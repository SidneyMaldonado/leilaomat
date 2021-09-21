package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.AnimalLeilao;
import com.example.leilao.repositories.AnimalLeilaoRepository;

public class AnimalLeilaoBiz {
	
	private Mensagem msg;
	private AnimalLeilaoRepository animalLeilaoRepository;
	
	public AnimalLeilaoBiz(AnimalLeilaoRepository animalLeilaoRepository) {
		super();
		this.msg = new Mensagem();
		this.animalLeilaoRepository = animalLeilaoRepository;
	}

	public Boolean validar(AnimalLeilao animalLeilao) {
		
		Boolean valid = true;
		
		if(animalLeilao.getIdAnimal() < 1 || animalLeilao.getIdLeilao() == null) {
			msg.mensagem.add("O campo de id animal nao pode ser menor que 1 ou nulo");
			valid = false;
		}
		if(animalLeilao.getIdLeilao() < 1 || animalLeilao.getIdLeilao() == null){
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

	public AnimalLeilaoRepository getAnimalLeilaoRepository() {
		return animalLeilaoRepository;
	}

	public void setAnimalLeilaoRepository(AnimalLeilaoRepository animalLeilaoRepository) {
		this.animalLeilaoRepository = animalLeilaoRepository;
	}
}
