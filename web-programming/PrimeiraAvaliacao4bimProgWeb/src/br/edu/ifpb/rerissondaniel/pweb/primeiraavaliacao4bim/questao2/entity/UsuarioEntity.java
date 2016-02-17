package br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.entity;

import br.edu.ifpb.rerissondaniel.pweb.database.util.commons.DataEntity;
import br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.bean.Usuario;
import br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao2.database.dao.UsuarioDao;

public class UsuarioEntity extends Usuario implements DataEntity<UsuarioEntity>{
	
	@Override
	public final UsuarioDao getDao() {
		return new UsuarioDao();
	}

}
