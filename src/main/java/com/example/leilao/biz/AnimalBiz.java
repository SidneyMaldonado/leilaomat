package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Animal;
import com.example.leilao.repositories.AnimalRepository;

public class AnimalBiz {
	
	private Mensagem msg;
	private AnimalRepository animalRepository;
	
	public AnimalBiz(AnimalRepository animalRepository) {
		super();
		this.msg = new Mensagem();
		this.animalRepository = animalRepository;
	}

	public Boolean validar(Animal animal) {
		
		Boolean valid = true;
		
		if(animal.getDescricao() == null || animal.getDescricao().length() < 1) {
			msg.mensagem.add("O campo de descricao não pode estar vazio");
			valid = false;
		}else if(animal.getDescricao().length() > 255 ) {
			msg.mensagem.add("O campo de descricao informado é muito grande");
			valid = false;
		}
		if(animal.getRegistro() == null || animal.getRegistro().length() < 1) {
			msg.mensagem.add("O campo de registro não pode estar vazio");
			valid = false;
		}else if(animal.getRegistro().length() > 8 ) {
			msg.mensagem.add("O campo de registro deve ser até 8 dígitos");
			valid = false;
		}
		if(animal.getPreco() == null || animal.getPreco() < 1) {
			msg.mensagem.add("O campo de preço não pode estar vazio ou negativo");
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

	public AnimalRepository getAnimalRepository() {
		return animalRepository;
	}

	public void setAnimalRepository(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}
}
