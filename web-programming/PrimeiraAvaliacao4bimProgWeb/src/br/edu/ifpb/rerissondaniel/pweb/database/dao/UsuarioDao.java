package br.edu.ifpb.rerissondaniel.pweb.database.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.rerissondaniel.pweb.database.util.JPA.JPAUtil;
import br.edu.ifpb.rerissondaniel.pweb.database.util.commons.GenericDao;

public class UsuarioDao extends GenericDao{
	
	private Session session;
	
	public UsuarioDao() {
		session = JPAUtil.getSessionFactory().openSession();
	}
	
	@Override
	public final Query getManagedQuery() {
		Query query = session.getNamedQuery("Usuario.getAll");
		return query;
	}

	@Override
	public void closeSession() {
		session.clear();
		session.close();
	}
}
