package controlador.sgb.benjismithperez.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloCuenta;
import modelo.sgb.benjismithperez.com.ModeloUsuario;
import modelo.sgb.benjismithperez.com.ModeloUxC;

/**
 * Servlet implementation class ServerletAsociarCuenta
 */
@WebServlet("/ServerletAsociarCuenta")
public class ServerletAsociarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletAsociarCuenta() {
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
		ModeloCuenta cu = new ModeloCuenta(request.getParameter("numCuenta"),0);
		ModeloUsuario u = new ModeloUsuario();
		u.setDni(request.getParameter("dni"));
		ControladorCuenta c = new ControladorCuenta(cu);
		ControladorUsuario cUs = new ControladorUsuario(u);
		if (c.CargarDatos()){
			cUs.CargarDatos();
			if (u.getTipo()!=-1){
				ModeloUxC mUxC = new ModeloUxC(u.getDni(),cu.getNumCuenta());
				ControladorUxC cUxC = new ControladorUxC(mUxC); 
				
				if (cUxC.ValidarCantidad()){
					if (!cUxC.ExisteAsociacion()){
						if (cUxC.Asociar()){
							request.setAttribute("exito", ".");
							RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
							rd.forward(request, response);
						} else {
							request.setAttribute("error", "No se pudo asociar cuenta a usuario.");
							RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
							rd.forward(request, response);
						}
					} else {
						request.setAttribute("error", "Ya existe esta asociaci'on.");
						RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("error", "No se puede asociar m'as de 4 cuentas.");
					RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("error", "El usuario no existe.");
				RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
				rd.forward(request, response);
			}	
		} else {
			request.setAttribute("error", "La cuenta no existe.");
			RequestDispatcher rd = request.getRequestDispatcher("admin/asociarCuenta.jsp");
			rd.forward(request, response);
		}
	}
}
