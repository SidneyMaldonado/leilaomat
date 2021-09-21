package com.example.leilao.biz;

import com.example.leilao.Mensagem;
import com.example.leilao.entities.Vendedor;
import com.example.leilao.repositories.VendedorRepository;

public class VendedorBiz {
	
	private Mensagem msg;
	private VendedorRepository vendedorRepository;
	
	public VendedorBiz(VendedorRepository vendedorRepository) {
		super();
		this.msg = new Mensagem();
		this.vendedorRepository = vendedorRepository;
	}

	public Boolean validar(Vendedor vendedor) {
		
		Boolean valid = true;
		
		if(vendedor.getIe().isEmpty() || vendedor.getIe().length() != 9)  {
			msg.mensagem.add("A inscrição estadual inserida não pode estar em branco ou ser diferente que 9 digitos");
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

	public VendedorRepository getVendedorRepository() {
		return vendedorRepository;
	}

	public void setVendedorRepository(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	
	
	
	
}
