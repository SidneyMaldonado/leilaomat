package com.example.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_animal_leilao")
public class AnimalLeilao {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="id_animal")
	private Integer idAnimal;
	
	@Column(name="id_leilao")
	private Integer idLeilao;
	
	public AnimalLeilao() {}

	public AnimalLeilao(Integer id, Integer idAnimal, Integer idLeilao) {
		super();
		this.id = id;
		this.idAnimal = idAnimal;
		this.idLeilao = idLeilao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public Integer getIdLeilao() {
		return idLeilao;
	}

	public void setIdLeilao(Integer idLeilao) {
		this.idLeilao = idLeilao;
	}
	
}
