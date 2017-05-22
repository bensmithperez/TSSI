package ejer1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Parte1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a = new ArrayList();
		a.add("Bensp");
		a.add("gato");
		a.add("agua");
		
		for (Object obj : a){
			System.out.println(obj);
		}
		
		a.set(2, "emm");
		
		for (Object obj : a){
			System.out.println(obj);
		}
		
		Collections.sort(a);
		
		ListIterator<Object> i = a.listIterator();
		while (i.hasNext()){
			System.out.println(i.next());
		}
	}
	

}
