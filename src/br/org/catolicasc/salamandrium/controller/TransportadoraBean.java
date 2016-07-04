package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import br.org.catolicasc.salamandrium.dao.TransportadoraDao;
import br.org.catolicasc.salamandrium.entity.Transportadora;

public class TransportadoraBean {

	private TransportadoraDao transportadoraDao = new TransportadoraDao();
	private Transportadora transportadora = new Transportadora();

	public Transportadora getTransportadora() {
		return this.transportadora;
	}
	
	public List<Transportadora> getTransportadoras() {
		return transportadoraDao.listaTodos();
	}
	
	public void salva() {
		this.transportadoraDao.salva(this.transportadora);
		this.transportadora = new Transportadora();
	}
	
	public void exclui(Transportadora transportadora) {
		transportadoraDao.remove(transportadora);;
	}
	
	public void edita(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
}
