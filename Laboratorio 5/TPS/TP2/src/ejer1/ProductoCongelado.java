package ejer1;

public class ProductoCongelado extends Producto {
	private float tempCongRecomendada;
	
	public ProductoCongelado(){
		super();
		tempCongRecomendada = 0;
	}

	public float getTempCongRecomendada() {
		return tempCongRecomendada;
	}

	public void setTempCongRecomendada(float tempCongRecomendada) {
		this.tempCongRecomendada = tempCongRecomendada;
	}
	
	public void mostrarDatos(){
		super.mostrarDatos();
		System.out.print("Temperatura de congelación recomendada: "+tempCongRecomendada);
	}
}
