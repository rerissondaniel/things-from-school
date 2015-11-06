
public class Usuario {
	private String usuario;
	private String senha;
	private String genero;
	private String nascimento;

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String senha, String genero, String nascimento) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.genero = genero;
		this.nascimento = nascimento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", senha=" + senha + ", genero=" + genero
				+ ", nascimento=" + nascimento + "]";
	}
	
}
