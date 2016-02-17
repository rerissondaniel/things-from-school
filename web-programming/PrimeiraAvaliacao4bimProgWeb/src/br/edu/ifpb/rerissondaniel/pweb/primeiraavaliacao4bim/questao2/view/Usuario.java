package br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.view;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifpb.rerissondaniel.pweb.database.dao.UsuarioDao;
import br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.entity.UsuarioEntity;

@ManagedBean(name = "usuarioBean")
public class Usuario {
	public List<UsuarioEntity> getAll(){
		UsuarioEntity entity = new UsuarioEntity();
		
		UsuarioDao dao = entity.getDao();
		
		@SuppressWarnings("unchecked")
		List<UsuarioEntity> usersList = (List<UsuarioEntity>) dao.getAll();
		
		return usersList;
	}
}
