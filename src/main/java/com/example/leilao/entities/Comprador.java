package com.example.leilao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_comprador")
public class Comprador {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="lance")
	private Double lance;
	
	@Column(name="id_tipo_pessoa")
	private Integer idTipoPessoa;

	public Comprador() {}

	public Comprador(Integer id, String cpf, Double lance, Integer idTipoPessoa) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.lance = lance;
		this.idTipoPessoa = idTipoPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getLance() {
		return lance;
	}

	public void setLance(Double lance) {
		this.lance = lance;
	}

	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}
}
