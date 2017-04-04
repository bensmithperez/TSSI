package ejercicio1;
import java.util.Scanner;
import java.util.Random;

public class Adivinador {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Random r = new Random();
		
		int numAleatorio = r.nextInt(99)+1;
		int numUsuario;
		int intento = 0;
		boolean esCorrecto = false;
		
		System.out.println("Se ha generado un número aleatorio, intente adivinarlo.");
		
		while (!esCorrecto && intento < 5){
			System.out.println("Ingrese un numero entre 1 y 100: ");
			numUsuario = entrada.nextInt();
			
			if (numUsuario > 0 && numUsuario <= 100){
				if (numUsuario == numAleatorio){
					esCorrecto = true;
				} else if (numUsuario > numAleatorio){
					System.out.println(intento == 4 ? "" : "Usted no ha acertado, debe ingresar un número menor al ingresado.");
					intento++;
				} else {
					System.out.println(intento == 4 ? "" : "Usted no ha acertado, debe ingresar un número mayor al ingresado.");
					intento++;
				}
			}
		}
		
		entrada.close();
		if (intento == 5){
			System.out.println("Usted ha perdido el juego.");
			System.out.println("El numero a adivinar era: " + numAleatorio + ".");
		} else {
			System.out.println("Usted ha ganado el juego.");
			System.out.println("El numero a adivinar era: " + numAleatorio + ".");
			System.out.println("Lo adivinó en " + intento + " intentos.");
		}
	}

}
