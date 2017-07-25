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
import modelo.sgb.benjismithperez.com.ModeloPagoServicio;
import modelo.sgb.benjismithperez.com.ModeloTransaccion;

/**
 * Servlet implementation class ServerletPagarServicio
 */
@WebServlet("/ServerletPagarServicio")
public class ServerletPagarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerletPagarServicio() {
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
					
					//cargo datos pago
					ModeloPagoServicio mp = new ModeloPagoServicio();
					mp.setIdServicio(Integer.parseInt(request.getParameter("servicio")));
					mp.setMonto(monto);
					
					Calendar today = Calendar.getInstance();
					today.set(Calendar.HOUR_OF_DAY, 0);
					Date fecha = today.getTime();
					
					ModeloTransaccion m = new ModeloTransaccion();
					m.setIdTipo(1);
					m.setFecha(fecha);
					m.setNumCuenta(request.getParameter("cuentasOrigen"));
					m.setEstado(1);
					
					ControladorTransaccion ct = new ControladorTransaccion(m);
					
					//pago
					if (ct.GenerarTransaccion(mp)){
						//hmmm.........
						if (cc.RestarSaldo(monto)){
							mc.setNumCuenta(request.getParameter("cuentaDestino"));
							
							request.setAttribute("exitoPago", "true");
							RequestDispatcher rd = request.getRequestDispatcher("ServerletServicios");
							rd.forward(request, response);
						}
					} else {
						request.setAttribute("error", "true");
						RequestDispatcher rd = request.getRequestDispatcher("ServerletServicios");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("errorSaldo", "true");
					RequestDispatcher rd = request.getRequestDispatcher("ServerletServicios");
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
