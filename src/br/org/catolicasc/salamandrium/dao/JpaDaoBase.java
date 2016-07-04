package br.org.catolicasc.salamandrium.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Query;

import br.org.catolicasc.salamandrium.entity.Bean;
import br.org.catolicasc.salamandrium.persistence.JpaUtil;

//import org.primefaces.model.LazyDataModel;

public abstract class JpaDaoBase<T extends Bean> implements Dao<T> {

	private final Class<T> classe;

	@SuppressWarnings("unchecked")
	public JpaDaoBase() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salva(T t) {
		if (t.getId() == null)
			JpaUtil.getEntityManager().persist(t);
		else
			JpaUtil.getEntityManager().merge(t);
	}

	public void remove(T t) {
		JpaUtil.getEntityManager().remove(this.buscaPorld(t.getId()));
	}

	public void atualiza(T t) {
		JpaUtil.getEntityManager().merge(t);
	}

	public List<T> listaTodos() {
		Query query = JpaUtil.getEntityManager().createQuery(getQueryAll());
		@SuppressWarnings("unchecked")
		List<T> lista = query.getResultList();
		return lista;
	}

	public T buscaPorld(Long id) {
		return (T) JpaUtil.getEntityManager().find(classe, id);
	}

	public List<T> listaPaginada(int ini, int max) {
		Query query = JpaUtil.getEntityManager().createQuery(getQueryAll());
		query.setFirstResult(ini);
		query.setMaxResults(max);
		@SuppressWarnings("unchecked")
		List<T> lista = query.getResultList();
		return lista;
	}

	protected String getQueryAll() {
		return "select t from " + classe.getName() + " t ";
	}

	/*public LazyDataModel<T> getLazyDataModel() {
		return new QueryDataModel<T>(getQueryAll());
	}*/
}