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
 * Servlet implementation class ServerletModificarUsuario
 */
@WebServlet("/ServerletModificarUsuario")
public class ServerletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletModificarUsuario() {
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
		// TODO Auto-generated method stub
		DateFormat format = new SimpleDateFormat("d/M/y");
		Date fechaNac;
		
		try {
			fechaNac = format.parse(request.getParameter("fechaNac"));
			
			ModeloUsuario u = new ModeloUsuario();
			u.setNombre(request.getParameter("nombre"));
			u.setApellido(request.getParameter("apellido"));
			u.setFechaNac(fechaNac);
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setUsuario(request.getParameter("usuario"));

			request.setAttribute("id", Integer.toString(u.getId()));
			request.setAttribute("usuario", u.getUsuario());
			request.setAttribute("nombre", u.getNombre());
			request.setAttribute("apellido", u.getApellido());
			request.setAttribute("fechaNac", u.getFechaNacString());
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/exitoModificar.jsp");
			rd.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
