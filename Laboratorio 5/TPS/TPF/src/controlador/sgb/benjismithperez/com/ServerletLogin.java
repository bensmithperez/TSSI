package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/ServerletLogin")
public class ServerletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ModeloUsuario u = new ModeloUsuario();
		u.setTipo(0);
		u.setUsuario(request.getParameter("usuario"));
		try {
			HttpSession session = request.getSession();
			u.setPass(request.getParameter("pass"));
			
			ControladorUsuario c = new ControladorUsuario(u);
			try{
				int res = c.Buscar();
				if (res == -1 || res > 1){
					 
					session.setAttribute("usuarioIncorrecto", true);
					RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);		
				} else if (res == 0){ 
					session.setAttribute("usuario", u.getUsuario());
					session.setAttribute("tipo", u.getTipo());
					RequestDispatcher rd = request.getRequestDispatcher("admin/home.jsp");
					rd.forward(request, response);
				} else if (res == 1){ 
					session.setAttribute("usuario", u.getUsuario());
					session.setAttribute("tipo", u.getTipo());
					RequestDispatcher rd = request.getRequestDispatcher("usuario/home.jsp");
					rd.forward(request, response);
				}	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
