package prueba;

import java.util.Scanner;

public class FactorialFor {

	public static void main(String[] args) {
		int numero = 0;
		long factorial = 1;
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Factor: ");
		numero = teclado.nextInt();
		
		for (int i=1;i<=numero;i++) {
			factorial = factorial*i; // factorial *= i;
		}
		System.out.println("Factorial="+factorial);
	}
}
