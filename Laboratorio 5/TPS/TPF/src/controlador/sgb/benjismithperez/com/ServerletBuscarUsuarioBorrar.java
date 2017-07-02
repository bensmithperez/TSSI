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
 * Servlet implementation class ServerletBuscarUsuarioBorrar
 */
@WebServlet("/ServerletBuscarUsuarioBorrar")
public class ServerletBuscarUsuarioBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletBuscarUsuarioBorrar() {
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
		u.setDni(request.getParameter("dni"));
		
		ControladorUsuario c = new ControladorUsuario(u);
		
		try{
			c.CargarDatos();
			request.setAttribute("id", u.getId());
			request.setAttribute("usuario", u.getUsuario());
			request.setAttribute("nombre", u.getNombre());
			request.setAttribute("apellido", u.getApellido());
			request.setAttribute("fechaNac", u.getFechaNacString());
			RequestDispatcher rd = request.getRequestDispatcher("admin/clientes/borrar.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
