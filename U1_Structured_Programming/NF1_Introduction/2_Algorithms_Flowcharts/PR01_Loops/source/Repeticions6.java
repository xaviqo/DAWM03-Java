import java.util.Scanner;

public class Repeticions6 {

	public static void main(String[] args) {
		
		int a, b, r = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Primer numero: ");
		a = keyboard.nextInt();
		
		System.out.println("Segundo numero: ");
		b = keyboard.nextInt();
		
		do {
			r=a%b;
			if (r==0) System.out.println("El MCD es: "+b);
			a=b;
			b=r;
			
			
		} while (r!=0);

	}

}
