package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.catolicasc.salamandrium.dao.FreteDao;
import br.org.catolicasc.salamandrium.entity.Frete;

@ManagedBean
@ViewScoped
public class FreteBean {

	private FreteDao freteDao = new FreteDao();
	private Frete frete = new Frete();
	
	public Frete getFrete() {
		return this.frete;
	}
	
	public List<Frete> getFretes() {
		return freteDao.listaTodos();
	}
	
	public void salva() {
		this.freteDao.salva(this.frete);
		this.frete = new Frete();
	}
	
	public void exclui(Frete frete) {
		freteDao.remove(frete);
	}
	
	public void edita(Frete frete) {
		this.frete = frete;
	}
}
