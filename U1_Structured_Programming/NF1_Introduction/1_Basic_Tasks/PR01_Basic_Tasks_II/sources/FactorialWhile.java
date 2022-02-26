package prueba;

import java.util.Scanner;

public class FactorialWhile {

	public static void main(String[] args) {
		int numero = 0;
		long factorial = 1;
		int factNum = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Factor: ");
		numero = teclado.nextInt();
		factNum = numero;
		
		 while (numero>0) {
			if (numero==factNum) {
				factorial = factorial * numero;
				System.out.print(factNum+"x");
				numero--;
			} else if (numero>1) {
				factorial = factorial * numero;
				numero--;
				System.out.print(numero+"x");
			} else {
				factorial = factorial * numero;
				System.out.print("0="+factorial);
				numero--;
			}
		}
		
		//System.out.println("El resultado es "+factorial);
		
		teclado.close();
	}

}
