package com.example.leilao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_atendimento")
public class Atendimento {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data_atendimento")
	private Date data;
	
	@Column(name="id_veterinario")
	private Integer idVeterinario;
	
	@Column(name="id_animal")
	private Integer idAnimal;

	public Atendimento() {}
	
	public Atendimento(Integer id, String descricao, Date data, Integer idVeterinario, Integer idAnimal) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.idVeterinario = idVeterinario;
		this.idAnimal = idAnimal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(Integer idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}
}
