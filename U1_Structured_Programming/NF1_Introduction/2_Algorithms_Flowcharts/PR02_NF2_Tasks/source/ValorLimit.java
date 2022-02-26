import java.util.Scanner;

public class ValorLimit {

	public static void main(String[] args) {

		float limite, sum, total = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Introduce un número límite: ");
		limite = keyboard.nextFloat();

		do {
			
			System.out.println("Numeros a sumar: ");
			sum = keyboard.nextFloat();

			total+=sum;
			System.out.println("La suma actual es "+total+" el límite "+limite);

		} while (total<limite);
		
		System.out.println("Has llegado al límite!");

	}

}
