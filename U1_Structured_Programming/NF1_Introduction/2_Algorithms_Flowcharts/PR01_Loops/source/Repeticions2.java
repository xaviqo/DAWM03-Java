import java.util.Scanner;

public class Repeticions2 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		int suma = 0;
				
		System.out.println("Introduce el primer numero: ");
		num1 = keyboard.nextInt();
		
		System.out.println("Introduce el segundo numero: ");
		num2 = keyboard.nextInt();
		
		
		while (num1<num2-1) {
			num1++;
			suma+=num1;
			System.out.println(suma);
		}
		


	}

}
