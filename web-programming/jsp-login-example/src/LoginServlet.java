
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "/LoginServlet", urlPatterns = "/loginServlet.do")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9211568140687018262L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		
		for (Usuario user : CadastroServlet.getUsuarios()){
			
			if(user.getUsuario().equals(usuario) && user.getSenha().equals(senha)){
				session.setAttribute("usuario", user);
				dispatcher = request.getRequestDispatcher("boas-vindas.jsp");
				break;
			}
		}
		
		dispatcher.forward(request, response);
	}

}