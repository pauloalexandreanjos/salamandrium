package br.org.catolicasc.salamandrium.controller;

import java.util.List;

import br.org.catolicasc.salamandrium.dao.UsuarioDao;
import br.org.catolicasc.salamandrium.entity.Usuario;

public class UsuarioBean {

	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return this.usuario; 
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioDao.listaTodos();
	}
	
	public void salva() {
		this.usuarioDao.salva(this.usuario);
		this.usuario = new Usuario();
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDao.remove(usuario);
	}
	
	public void edita(Usuario usuario) {
		this.usuario = usuario;
	}
}
