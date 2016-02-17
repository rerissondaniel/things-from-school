package br.edu.ifpb.rerissondaniel.pweb.database.util.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpb.rerissondaniel.pweb.database.util.JPA.JPAUtil;


public class HibernateListener implements ServletContextListener {  
	  
    public void contextInitialized(ServletContextEvent event) {  
        JPAUtil.getSessionFactory(); 
    }  
  
    public void contextDestroyed(ServletContextEvent event) {  
    	JPAUtil.getSessionFactory().close();
    }  
} 
