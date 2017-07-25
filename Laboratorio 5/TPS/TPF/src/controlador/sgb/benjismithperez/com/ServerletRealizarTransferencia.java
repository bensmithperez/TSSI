package controlador.sgb.benjismithperez.com;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.sgb.benjismithperez.com.ModeloCuenta;
import modelo.sgb.benjismithperez.com.ModeloTransaccion;
import modelo.sgb.benjismithperez.com.ModeloTransferencia;

/**
 * Servlet implementation class ServerletRealizarTransferencia
 */
@WebServlet("/ServerletRealizarTransferencia")
public class ServerletRealizarTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletRealizarTransferencia() {
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
		try{	
			float monto = Float.parseFloat(request.getParameter("monto"));
			
			//comprobar saldo
			ModeloCuenta mc = new ModeloCuenta();
			mc.setNumCuenta(request.getParameter("cuentasOrigen"));
			ControladorCuenta cc = new ControladorCuenta(mc);
			if (cc.CargarDatos()){
				if (cc.ValidarSaldo(monto)){
					
					//cargo datos transferencia
					ModeloTransferencia mt = new ModeloTransferencia();
					mt.setCuentaDestino(request.getParameter("cuentaDestino"));
					mt.setMonto(monto);
					
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR_OF_DAY, 0);
					Date fecha = today.getTime();
					
					ModeloTransaccion m = new ModeloTransaccion();
					m.setIdTipo(0);
					m.setFecha(fecha);
					m.setNumCuenta(request.getParameter("cuentasOrigen"));
					m.setEstado(1);
					
					ControladorTransaccion ct = new ControladorTransaccion(m);
					
					//transfiero
					if (ct.GenerarTransaccion(mt)){
						//hmmm.........
						if (cc.RestarSaldo(monto)){
							mc.setNumCuenta(request.getParameter("cuentaDestino"));
							ControladorCuenta c1 = new ControladorCuenta(mc);
							if (c1.SumarSaldo(monto)){								
								request.setAttribute("exitoTransferencia", "true");
								RequestDispatcher rd = request.getRequestDispatcher("ServerletTransferencias");
								rd.forward(request, response);
							}
						}
					} else {
						request.setAttribute("error", "true");
						RequestDispatcher rd = request.getRequestDispatcher("ServerletTransferencias");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("errorSaldo", "true");
					RequestDispatcher rd = request.getRequestDispatcher("ServerletTransferencias");
					rd.forward(request, response);
				}
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
