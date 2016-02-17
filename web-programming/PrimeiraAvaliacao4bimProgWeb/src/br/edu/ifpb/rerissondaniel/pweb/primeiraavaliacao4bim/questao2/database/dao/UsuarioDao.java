package br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.database.dao;

import org.hibernate.Query;

import br.edu.ifpb.rerissondaniel.pweb.database.util.JPA.JPAUtil;
import br.edu.ifpb.rerissondaniel.pweb.database.util.commons.GenericDao;

public class UsuarioDao extends GenericDao{
	
	public UsuarioDao() {
		setSession(JPAUtil.getSessionFactory().openSession());
	}
	
	@Override
	public final Query getManagedQuery() {
		Query query = getSession().getNamedQuery("Usuario.getAll");
		return query;
	}

	@Override
	public void closeSession() {
		getSession().clear();
		getSession().close();
	}
}
