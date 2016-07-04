package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.org.catolicasc.salamandrium.dao.CotacaoDao;
import br.org.catolicasc.salamandrium.entity.Cotacao;


@ManagedBean
@ViewScoped
public class CotacaoBean {

	private CotacaoDao cotacaoDao = new CotacaoDao();
	private Cotacao cotacao = new Cotacao();
	
	public Cotacao getCotacao() {
		return this.cotacao;
	}
	
	public List<Cotacao> getCotacoes() {
		return this.cotacaoDao.listaTodos();
	}
	
	public void salva() {
		this.cotacaoDao.salva(cotacao);
		this.cotacao = new Cotacao();
	}
	
	public void exclui(Cotacao cotacao) {
		this.cotacaoDao.remove(cotacao);
	}
	
	public void edita(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
}
