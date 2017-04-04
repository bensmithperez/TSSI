package ejercicio3;

import ejercicio3.Profesor;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Profesor p1 = new Profesor();
		Profesor p2 = new Profesor("Matemática",2,"Juan",50);
		Profesor p3 = new Profesor("Programación",10,"Pepe",20);
		
		System.out.println(p1.devuelveDatos());
		System.out.println(p2.devuelveDatos());
		System.out.println(p3.devuelveDatos());
	}

}
