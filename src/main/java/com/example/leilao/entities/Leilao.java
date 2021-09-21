package com.example.leilao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_leilao")
public class Leilao {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data_leilao")
	private Date data;
	
	@Column(name="id_empresa_leilao")
	private Integer idEmpresaLeilao;
	
	public Leilao() {}

	public Leilao(Integer id, String descricao, Date data, Integer idEmpresaLeilao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.idEmpresaLeilao = idEmpresaLeilao;
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

	public Integer getIdEmpresaLeilao() {
		return idEmpresaLeilao;
	}

	public void setIdEmpresaLeilao(Integer idEmpresaLeilao) {
		this.idEmpresaLeilao = idEmpresaLeilao;
	}
	
}
