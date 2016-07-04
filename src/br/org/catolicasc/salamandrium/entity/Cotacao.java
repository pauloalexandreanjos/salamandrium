package br.org.catolicasc.salamandrium.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cotacao implements Bean {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private List<Produto> produtos;
	private double valor;
	
	@OneToMany
	private Local destino;
	
	@OneToMany
	private Local origem;
	
	private int status;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Local getDestino() {
		return destino;
	}
	public void setDestino(Local destino) {
		this.destino = destino;
	}
	public Local getOrigem() {
		return origem;
	}
	public void setOrigem(Local origem) {
		this.origem = origem;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	
}