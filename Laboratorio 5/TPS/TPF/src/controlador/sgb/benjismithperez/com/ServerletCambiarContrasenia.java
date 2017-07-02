package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

/**
 * Servlet implementation class ServerletCambiarContrasenia
 */
@WebServlet("/ServerletCambiarContrasenia")
public class ServerletCambiarContrasenia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletCambiarContrasenia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModeloUsuario u = new ModeloUsuario();
		System.err.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		u.setId(id);

		try {
			u.setPass(request.getParameter("pass"));
			
			ControladorUsuario c = new ControladorUsuario(u);
			if (c.CambiarContraeniaUsuario()){
				request.setAttribute("exitoModificarContrasenia", "true");
				RequestDispatcher rd = request.getRequestDispatcher("/admin/exito.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorModificarContrasenia", "true");
				RequestDispatcher rd = request.getRequestDispatcher("/admin/clientes/cambiarContrasenia.jsp");
				rd.forward(request, response);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
