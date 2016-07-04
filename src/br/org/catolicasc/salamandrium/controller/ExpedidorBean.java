package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.org.catolicasc.salamandrium.dao.ExpedidorDao;
import br.org.catolicasc.salamandrium.entity.Expedidor;

@ManagedBean
@ViewScoped
public class ExpedidorBean {

	private ExpedidorDao expedidorDao = new ExpedidorDao();
	private Expedidor expedidor = new Expedidor();
	
	public Expedidor getExpedidor() {
		return this.expedidor;
	}
	
	public List<Expedidor> getExpedidores() {
		return expedidorDao.listaTodos();
	}
	
	public void salva() {
		this.expedidorDao.salva(expedidor);
		this.expedidor = new Expedidor();
	}
	
	public void exclui(Expedidor expedidor) {
		expedidorDao.remove(expedidor);
	}
	
	public void edita(Expedidor expedidor) {
		this.expedidor = expedidor;
	}
}
