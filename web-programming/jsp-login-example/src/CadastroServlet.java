
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet(name = "/CadastroServlet", urlPatterns = "/cadastroServlet.do")

public class CadastroServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1818115445546311825L;

	private static List<Usuario> usuarios;
	Usuario usuario;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		usuario = new Usuario();
		
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setGenero(request.getParameter("genero"));
		usuario.setNascimento(request.getParameter("nascimento"));
		
		if(usuario.getSenha().equals(request.getParameter("re-senha"))){
			usuarios.add(usuario);
			
			response.sendRedirect("index.html");
			
		}else{
			response.sendRedirect("cadastro.jsp");
		}
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		CadastroServlet.usuarios = usuarios;
	}
	
}
