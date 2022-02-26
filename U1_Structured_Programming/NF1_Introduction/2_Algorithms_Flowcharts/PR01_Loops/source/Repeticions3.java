import java.util.Scanner;

public class Repeticions3 {
	
	public static void main(String[] args) {
		
		int num = -1;
		
		Scanner keyboard = new Scanner(System.in);

		do {
			
			System.out.println("Introduce un número: ");
			num = keyboard.nextInt();
			
		} while (num>=0);
		
		
	}
}
