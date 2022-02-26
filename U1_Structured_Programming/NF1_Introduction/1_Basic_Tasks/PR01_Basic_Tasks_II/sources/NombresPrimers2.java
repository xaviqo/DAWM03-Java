package prueba;

import java.util.Scanner;

public class NombresPrimers2 {

	public static void main(String[] args) {

		int numero = 0;
		boolean primer = true;
		int cuantos = 0;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Comprobar numero: ");
		numero = teclado.nextInt();
		
		System.out.println("Números primos hasta "+numero+": ");
		System.out.print("| ");

		for (int i = 2; i<=numero; i++) {
			primer = true;
			if (i%2!=0) {
				for (int j = 2; j<i; j++) {
					if (i%j == 0) {
						primer = false;
						break;
					}
				}
			} else {
				primer = false;
			}
			if (primer) {
				System.out.print(i+" | ");
				cuantos++;
			}
		}
		System.out.println(" ");
		
		System.out.println("Números primos encontrados: "+cuantos);

	}

}
