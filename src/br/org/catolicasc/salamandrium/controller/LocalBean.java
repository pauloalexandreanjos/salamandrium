package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.catolicasc.salamandrium.dao.LocalDao;
import br.org.catolicasc.salamandrium.entity.Local;

@ManagedBean
@ViewScoped
public class LocalBean {

	private LocalDao localDao = new LocalDao();
	private Local local = new Local();
	
	public Local getLocal() {
		return this.local;
	}
	
	public List<Local> getLocais() {
		return localDao.listaTodos();
	}
	
	public void salva() {
		this.localDao.salva(this.local);
		this.local = new Local();
	}
	
	public void exclui(Local local) {
		this.localDao.remove(local);
	}
	
	public void edita(Local local) {
		this.local = local;
	}
}
