package modelo.sgb.benjismithperez.com;

public class ModeloUxC {
	private String dniUsuario;
	private String numCuenta;
	
	public ModeloUxC(){
		
	}

	public ModeloUxC(String dniUsuario, String numCuenta) {
		this.dniUsuario = dniUsuario;
		this.numCuenta = numCuenta;
		System.err.println("ModeloUxC: dni: " + this.dniUsuario + " numCuenta: " + this.numCuenta);
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
}
