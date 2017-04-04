package ejercicio2;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado e1 = new Empleado();
		Empleado e2 = new Empleado("Juan", 51);
		Empleado e3 = new Empleado("Pedro",12);
		Empleado e4 = new Empleado("Pepe", 123);
		
		System.out.println(e1.devuelveDatos());
		System.out.println(e2.devuelveDatos());
		System.out.println(e3.devuelveDatos());
		System.out.println(e4.devuelveDatos());
	}

}
