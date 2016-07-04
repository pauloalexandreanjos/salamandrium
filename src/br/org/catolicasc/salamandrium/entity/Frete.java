package br.org.catolicasc.salamandrium.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Frete implements Bean{

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	private Cotacao cotacao;
	
	private double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cotacao getCotacao() {
		return cotacao;
	}
	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
