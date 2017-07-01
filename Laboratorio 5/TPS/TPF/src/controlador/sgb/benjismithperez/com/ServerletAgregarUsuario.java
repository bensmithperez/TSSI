package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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
 * Servlet implementation class ServerletAgregarUsuario
 */
@WebServlet("/ServerletAgregarUsuario")
public class ServerletAgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletAgregarUsuario() {
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
		DateFormat format = new SimpleDateFormat("d/M/y");
		Date fechaNac;
		try {
			fechaNac = format.parse(request.getParameter("fechaNac"));
			
			ModeloUsuario u = new ModeloUsuario(1,
					request.getParameter("usuario"),
					request.getParameter("pass"),
					true,
					request.getParameter("nombre"),
					request.getParameter("apellido"),
					request.getParameter("dni"),
					fechaNac);
			
			ControladorUsuario c = new ControladorUsuario(u);
			c.Agregar();
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
