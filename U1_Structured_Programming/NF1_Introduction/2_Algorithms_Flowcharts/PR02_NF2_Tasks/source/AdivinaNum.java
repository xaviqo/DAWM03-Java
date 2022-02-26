import java.util.Random;
import java.util.Scanner;

public class AdivinaNum {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner opcion = new Scanner(System.in);
		
		int numUser = -1;
		int numJava = ;
		

		while (true) {
			
			System.out.println("Que número estoy pensando?:");
			numUser = opcion.nextInt();
			
			if (numUser<numJava) System.out.println("Estoy aquí arriba! Mi número es más alto...");
			if (numUser>numJava) System.out.println("No te pases! Mi número es más bajo...");
			if (numUser==0) return;
			if (numUser==numJava) {
				System.out.println("¡Correcto!");
				System.out.println("Mi número era "+numJava);
				return;
				
			}
		}
		
	}

}
