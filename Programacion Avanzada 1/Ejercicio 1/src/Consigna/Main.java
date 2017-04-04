package Consigna;

public class Main {

	public static void main(String[] args) {
		Animal p1 = new Perro();
		Animal p2 = new Perro("Cookie", 18);
		Animal g1 = new Gato();
		
		p1.dormir();
		p2.comunicarse();
		g1.comunicarse();
	}
}
