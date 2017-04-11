package ejer1;

public class Principal {

	public static void main(String[] args) {
		Producto p1 = new Producto();
		p1.mostrarDatos();
		
		Producto pf1 = new ProductoFresco();
		pf1.mostrarDatos();
		
		Producto pr1 = new ProductoRefrigerado();
		pr1.mostrarDatos();
		
		Producto pc1 = new ProductoCongelado();
		pc1.mostrarDatos();
	}

}
