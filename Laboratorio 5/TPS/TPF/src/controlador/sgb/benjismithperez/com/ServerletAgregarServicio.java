package controlador.sgb.benjismithperez.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloServicio;

/**
 * Servlet implementation class ServerletAgregarServicio
 */
@WebServlet("/ServerletAgregarServicio")
public class ServerletAgregarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletAgregarServicio() {
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
		ModeloServicio m = new ModeloServicio();
		m.setDescripcion(request.getParameter("descripcion"));
		ControladorServicio c = new ControladorServicio(m);

		if (c.Agregar()){
			request.setAttribute("servicioCreado", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/servicios/crear.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errorS", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/servicios/crear.jsp");
			rd.forward(request, response);
		}
	}

}
