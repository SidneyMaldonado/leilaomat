package com.example.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_vendedor")
public class Vendedor {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ie")
	private String ie;
	
	@Column(name="id_tipo_pessoa")
	private Integer idTipoPessoa;

	public Vendedor() {}

	public Vendedor(Integer id, String ie, Integer idTipoPessoa) {
		super();
		this.id = id;
		this.ie = ie;
		this.idTipoPessoa = idTipoPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}
}
