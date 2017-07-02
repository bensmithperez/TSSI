package modelo.sgb.benjismithperez.com;

public class ModeloCuenta {
	private String numCuenta;
	private float monto;
	
	public ModeloCuenta() {
	}
	
	public ModeloCuenta(String numCuenta, float monto) {
		this.numCuenta = numCuenta;
		this.monto = monto;
	}

	public String getNumCuenta() {
		return numCuenta;
	}
	
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public float getMonto() {
		return monto;
	}
	
	public void setMonto(float monto) {
		this.monto = monto;
	}
}
