package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.sgb.benjismithperez.com.ModeloCuenta;
import modelo.sgb.benjismithperez.com.ModeloUsuario;
import modelo.sgb.benjismithperez.com.ModeloUxC;

/**
 * Servlet implementation class ServerletServicios
 */
@WebServlet("/ServerletServicios")
public class ServerletServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletServicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			ModeloUsuario u = new ModeloUsuario();
			u.setUsuario(session.getAttribute("usuario").toString());
			ControladorUsuario cu = new ControladorUsuario(u);
			cu.BuscarDni();
			ModeloUxC muxc = new ModeloUxC();
			ControladorUxC c = new ControladorUxC(muxc);

			List<ModeloCuenta> listaCuentas = c.cargarCuentasUsuario(u.getDni());
			request.setAttribute("listaCuentas", listaCuentas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/pagarServicio.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
