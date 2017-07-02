package controlador.sgb.benjismithperez.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

/**
 * Servlet implementation class ServerletBorrarUsuario
 */
@WebServlet("/ServerletBorrarUsuario")
public class ServerletBorrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletBorrarUsuario() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		System.err.println("id: "+id);
		u.setId(id);
		
		ControladorUsuario c = new ControladorUsuario(u);
		if (c.BorrarUsuario()){
			request.setAttribute("exitoBorrarCliente", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/exito.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errorBorrarCliente", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/clientes/borrar.jsp");
			rd.forward(request, response);
		}
	}

}
