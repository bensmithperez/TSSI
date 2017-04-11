package ejer1;
import java.util.Date;

public class ProductoFresco extends Producto{
	private Date fechaEnvasado;
	private String paisOrigen;
	
	public ProductoFresco(){
		super();
		fechaEnvasado = new Date();
		paisOrigen = "";
	}
	
	public Date getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(Date fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	public void mostrarDatos(){
		super.mostrarDatos();
		System.out.print("Fecha Envasado: "+fechaEnvasado+
				"\nPais origen: "+paisOrigen);
	}
}
