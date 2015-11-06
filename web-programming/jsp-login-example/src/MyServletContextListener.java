import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		CadastroServlet.setUsuarios(null);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		CadastroServlet.setUsuarios(new ArrayList<Usuario>());
	}

}
