package com.example.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_veterinario")
public class Veterinario {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="crmv")
	private String crmv;
	
	@Column(name="id_tipo_pessoa")
	private Integer idTipoPessoa;

	public Veterinario() {}

	public Veterinario(Integer id, String crmv, Integer idTipoPessoa) {
		super();
		this.id = id;
		this.crmv = crmv;
		this.idTipoPessoa = idTipoPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}
}
