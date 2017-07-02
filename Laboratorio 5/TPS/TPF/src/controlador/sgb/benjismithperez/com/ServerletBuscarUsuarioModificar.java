
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
 * Servlet implementation class ServerletBuscarUsuarioModificar
 */
@WebServlet("/ServerletBuscarUsuarioModificar")
public class ServerletBuscarUsuarioModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletBuscarUsuarioModificar() {
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
			if (u.getTipo()!=-1){
				request.setAttribute("id", u.getId());
				request.setAttribute("usuario", u.getUsuario());
				request.setAttribute("nombre", u.getNombre());
				request.setAttribute("apellido", u.getApellido());
				request.setAttribute("fechaNac", u.getFechaNacString());
				request.setAttribute("cambiarContrasenia", request.getContextPath()+"/admin/clientes/cambiarContrasenia.jsp?usuario="+u.getId());
				request.setAttribute("cambiarContraseniaTexto", "Cambiar Contraseña");
				RequestDispatcher rd = request.getRequestDispatcher("admin/clientes/modificar.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("usuarioNoExiste", "true");
				RequestDispatcher rd = request.getRequestDispatcher("admin/clientes/modificar.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
