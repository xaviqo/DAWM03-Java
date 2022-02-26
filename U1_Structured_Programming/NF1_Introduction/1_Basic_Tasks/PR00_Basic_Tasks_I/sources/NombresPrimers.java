package prueba;

import java.util.Scanner;

public class NombresPrimers {

	public static void main(String[] args) {

		int numero = 0;
		boolean primer = true;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Comprobar numero: ");
		numero = teclado.nextInt();

			for (int i = 2; i<=numero; i++) {
				primer = true;
				for (int j = 2; j<i; j++) {
					if (i%j == 0) {
						primer = false;
						break;
					}
				}
				if (primer) System.out.print(i+" / ");
			}

		System.out.println(" ");

	}

}
