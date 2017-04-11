package ejer1;

public class ProductoRefrigerado extends Producto{
	private String codigoOSA;
	
	public ProductoRefrigerado(){
		super();
		codigoOSA = "";
	}

	public String getCodigoOSA() {
		return codigoOSA;
	}

	public void setCodigoOSA(String codigoOSA) {
		this.codigoOSA = codigoOSA;
	}
	
	public void mostrarDatos(){
		super.mostrarDatos();
		System.out.print("Codigo OSA: "+codigoOSA);
	}
}
