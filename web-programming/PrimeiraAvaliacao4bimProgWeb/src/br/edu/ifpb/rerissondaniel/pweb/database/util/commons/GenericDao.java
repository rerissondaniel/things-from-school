package br.edu.ifpb.rerissondaniel.pweb.database.util.commons;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.rerissondaniel.pweb.database.util.JPA.JPAUtil;

public abstract class GenericDao {
	
	private Session session;
	
	public int insert(DataEntity<?> entity){
		Session session = JPAUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return entity.getId();
	}

	public void update(DataEntity<?> entity) {
		Session session = JPAUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			hexp.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	public void delete(DataEntity<?> entity) {
		Session session = JPAUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();

		} catch (HibernateException hexp) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	public List<?> getAll(){
		return getManagedQuery().list();
	}

	public DataEntity<?>  getById(Integer pk){
		//TODO
		return null;
	}
	
	public abstract Query getManagedQuery();
	
	public abstract void closeSession();

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}