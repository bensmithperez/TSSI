package ejer1;
import java.util.Date;

public class Producto {
	private Date fechaCaducidad;
	private int numLote;
	
	public Producto(){
		fechaCaducidad = new Date();
		numLote = 0;
	}
	
	public Producto(Date fechaCaducidad, int numLote){
		this.fechaCaducidad = fechaCaducidad;
		this.numLote = numLote;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumLote() {
		return numLote;
	}

	public void setNumLote(int numLote) {
		this.numLote = numLote;
	}
	
	public void mostrarDatos(){
		System.out.print("\nDatos:\nFecha de Caducidad: "+
				fechaCaducidad+"\nNumero de lote: "+numLote);
	}
}
