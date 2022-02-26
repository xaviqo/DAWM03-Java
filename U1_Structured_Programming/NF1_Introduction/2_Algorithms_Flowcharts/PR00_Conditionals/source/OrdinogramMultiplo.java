import java.util.Scanner;

public class OrdinogramMultiplo {

	public static void main(String[] args) {
		
		int number = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Inserta un numero: ");
		number = keyboard.nextInt();
		
		if (number%2==0 && number%3==0) {
			System.out.println("Es multiplo de 2 y de 3");
		} else if (number%2==0){
			System.out.println("Solo es multiplo de 2");
		} else if (number%3==0) {
			System.out.println("Solo es multiplo de 3");
		} else {
			System.out.println("No es multiplo de 2 o 3");
		}
	}

}
