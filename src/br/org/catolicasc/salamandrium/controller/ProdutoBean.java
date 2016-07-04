package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import br.org.catolicasc.salamandrium.dao.ProdutoDao;
import br.org.catolicasc.salamandrium.entity.Produto;

public class ProdutoBean {

	private ProdutoDao produtoDao = new ProdutoDao();
	private Produto produto = new Produto();
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public List<Produto> getProdutos() {
		return produtoDao.listaTodos();
	}
	
	public void salva() {
		this.produtoDao.salva(this.produto);
		this.produto = new Produto();
	}
	
	public void exclui(Produto produto) {
		produtoDao.remove(produto);
	}
	
	public void edita(Produto produto) {
		this.produto = produto;
	}
}
