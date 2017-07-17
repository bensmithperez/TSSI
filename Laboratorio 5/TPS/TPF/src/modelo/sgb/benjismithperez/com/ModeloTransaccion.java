package modelo.sgb.benjismithperez.com;

import java.util.Date;

public class ModeloTransaccion {
	private int id;
	private int idTipo;
	private Date fecha;
	private String numCuenta;
	private int estado;
	
	public ModeloTransaccion(){
		
	}
	
	public ModeloTransaccion(int id, int idTipo, Date fecha, String numCuenta, int estado) {
		this.id = id;
		this.idTipo = idTipo;
		this.fecha = fecha;
		this.numCuenta = numCuenta;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}
