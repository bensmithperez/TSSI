package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloCuenta;

/**
 * Servlet implementation class ServerletAgregarCuenta
 */
@WebServlet("/ServerletAgregarCuenta")
public class ServerletAgregarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletAgregarCuenta() {
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
		float monto = Float.parseFloat(request.getParameter("monto"));
		ModeloCuenta cu = new ModeloCuenta(request.getParameter("numCuenta"),monto);
		
		ControladorCuenta c = new ControladorCuenta(cu);
					
		if (c.Agregar()){
			request.setAttribute("cuentaCreada", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cuentas/crear.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errorC", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cuentas/crear.jsp");
			rd.forward(request, response);
		}
	
	}

}
