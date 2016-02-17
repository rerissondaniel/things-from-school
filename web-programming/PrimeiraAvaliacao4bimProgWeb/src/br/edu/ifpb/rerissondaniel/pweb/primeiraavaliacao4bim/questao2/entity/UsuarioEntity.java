package br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.entity;

import br.edu.ifpb.rerissondaniel.pweb.database.dao.UsuarioDao;
import br.edu.ifpb.rerissondaniel.pweb.database.util.commons.DataEntity;
import br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.bean.Usuario;

public class UsuarioEntity extends Usuario implements DataEntity<UsuarioEntity>{
	
	@Override
	public final UsuarioDao getDao() {
		return new UsuarioDao();
	}

}
