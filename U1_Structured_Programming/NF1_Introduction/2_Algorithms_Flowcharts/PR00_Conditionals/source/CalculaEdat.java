import java.util.Scanner;

public class CalculaEdat {

	public static void main(String[] args) {
		
		// persona 1
		int age1 = 0;
		String name1 = "";
		// persona 2
		int age2 = 0;
		String name2 = "";
		// persona 3
		int age3 = 0;
		String name3 = "";
		
		Scanner keyboard = new Scanner(System.in);
		
		//resto de vars
		boolean sameAge = false;
		
		// capturar nombres
		
		System.out.println("Introduce los datos de la primera persona");
		
		System.out.println("Nombre: ");
		name1 = keyboard.next();
		System.out.println("Edad: ");
		age1 = keyboard.nextInt();
		
		System.out.println("Ok! Ahora la segunda persona");
		
		System.out.println("Nombre (2ª per): ");
		name2 = keyboard.next();
		System.out.println("Edad (2ª per): ");
		age2 = keyboard.nextInt();
		
		System.out.println("Y la ultima?");
		
		System.out.println("Nombre (3ª per): ");
		name3 = keyboard.next();
		System.out.println("Edad (3ª per): ");
		age3 = keyboard.nextInt();
		
		// comprobar edades
		if (age1>age2 && age1>age3) {
			System.out.print(name1+" es el mayor ");
			if (age2>age3) {
				System.out.println("y "+name2+" es mayor que "+name3);
			} else {
				System.out.println("y "+name3+" es mayor que "+name2);			}
		} else if (age2>age1 && age2>age3) {
			System.out.print(name2+" es el mayor ");
			if (age1>age3) {
				System.out.println("y "+name1+" es mayor que "+name3);
			} else {
				System.out.println("y "+name3+" es mayor que "+name1);			}
		} else {
			System.out.print(name3+" es el mayor ");
			if (age1>age2) {
				System.out.println("y "+name1+" es mayor que "+name2);
			} else {
				System.out.println("y "+name2+" es mayor que "+name1);			}
		} 
		
		
	}

	
}
