import java.util.Scanner;

public class OrdinogramMayorQue10 {

	public static void main(String[] args) {
		
		int number = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Inserta un numero: ");
		number = keyboard.nextInt();
		
		if (number>10) {
			System.out.println(number+" es mayor que 10");
		} else if (number==10) {
			System.out.println(number+" es igual a 10");
		} else {
			System.out.println(number+" es menor que 10");
		}
		

	}

}
