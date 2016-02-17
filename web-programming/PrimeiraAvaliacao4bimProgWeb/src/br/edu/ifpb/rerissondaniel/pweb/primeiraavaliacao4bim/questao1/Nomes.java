package br.edu.ifpb.rerissondaniel.pweb.primeiraavaliacao4bim.questao1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "nomesBean")
@RequestScoped
public class Nomes {
	private String campo1;
	private String campo2;

	public void inverteNomes() {
		String aux = campo1;
		campo1 = campo2;
		campo2 = aux;
	}

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

}
