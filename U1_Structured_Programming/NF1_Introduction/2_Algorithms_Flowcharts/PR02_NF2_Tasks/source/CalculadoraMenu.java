import java.util.Scanner;

public class CalculadoraMenu {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		int option = -1;
		float num1, num2 = 0;
		
		while (true) {
			
			switch (option) {
			
			case 0:   
				//para el programa
				return;
			case 1:
				System.out.println("Primer número: ");
				num1 = key.nextFloat();
				System.out.println("Segundo número");
				num2 = key.nextFloat();
				
				System.out.println("El resultado es:");
				System.out.println(num1+num2);
				System.out.println("");
				break;
			case 2:
				System.out.println("Primer número: ");
				num1 = key.nextFloat();
				System.out.println("Segundo número");
				num2 = key.nextFloat();
				
				System.out.println("El resultado es:");
				System.out.println(num1-num2);
				System.out.println("");
				break;
			case 3:
				System.out.println("Primer número: ");
				num1 = key.nextFloat();
				System.out.println("Segundo número");
				num2 = key.nextFloat();
				
				System.out.println("El resultado es:");
				System.out.println(num1*num2);
				System.out.println("");
				break;
			case 4:
				System.out.println("Primer número: ");
				num1 = key.nextFloat();
				System.out.println("Segundo número");
				num2 = key.nextFloat();
				
				System.out.println("El resultado es:");
				System.out.println(num1/num2);
				System.out.println("");
				break;
				
			}
			System.out.println("0 - Salir");
			System.out.println("1 - Sumar");
			System.out.println("2 - Restar");
			System.out.println("3 - Multiplicar");
			System.out.println("4 - Dividir");
			System.out.println("Selecciona una opción:");
			
			option = key.nextInt();
		}


	}

}
