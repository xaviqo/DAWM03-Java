import java.util.Scanner;

public class Repeticions4 {

	public static void main(String[] args) {

		//boolean stop = true;
		int num = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
		
			System.out.println("Introducir 0 para detener programa");
			System.out.println("Introduce un numero positivo o negativo: ");
			num = keyboard.nextInt();
			
			if (num==0) break;
			
			//positiu o negatiu, parells o mult de 4
			
			if (num>0) {
				System.out.print(num+" es un número positivo,");
			} else {
				System.out.print(num+" es un número negativo,");
			}
			
			if (num%2==0) {
				System.out.print(" par y ");
			} else {
				System.out.print(" impar y ");
			}
			
			if (num%4==0) {
				System.out.println("múltiple de 4.");
				System.out.println("________________________________");
				System.out.println("");
			} else {
				System.out.println("no es múltiple de 4.");
				System.out.println("________________________________");
				System.out.println("");
			}
			
		}

	}
}
