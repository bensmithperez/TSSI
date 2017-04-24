package io;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgregarLinea {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter outputStream = null;
		
		try{
			outputStream = new PrintWriter(new FileWriter("salida.txt"));
			Scanner reader = new Scanner(System.in);
			String texto = "";
			while ((!texto.equals("q"))){
				  // Reading from System.in
				System.out.println("Ingresar una nueva linea: ");
				texto = reader.next();
				outputStream.println(texto);
			}
			reader.close();
		} finally {
			if (outputStream != null){
				outputStream.close();
			}
			
		}
	}

}
