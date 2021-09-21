package com.example.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_animal_venda")
public class AnimalVenda {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="id_venda")
	private Integer idVenda;
	
	@Column(name="id_animal")
	private Integer idAnimal;
	
	public AnimalVenda() {}

	public AnimalVenda(Integer id, Integer idVenda, Integer idAnimal) {
		super();
		this.id = id;
		this.idVenda = idVenda;
		this.idAnimal = idAnimal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}
}
