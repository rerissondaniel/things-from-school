package br.edu.ifpb.rerissondaniel.pweb.database.util.commons;


public interface DataEntity<T> {
	public Integer getId();
	
	public GenericDao getDao();
}
