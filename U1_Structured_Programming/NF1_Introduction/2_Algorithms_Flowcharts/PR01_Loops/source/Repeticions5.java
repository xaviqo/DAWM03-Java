import java.util.Scanner;

public class Repeticions5 {

	public static void main(String[] args) {

		// sumar todos y dividir por cantidad de ntoas
		int counter = 0;
		int nota = 0;
		int sumas = 0;
		boolean loop = true;
		
		// notas
		int exc = 0;
		int not = 0;
		int bie = 0;
		int suf = 0;
		int ins = 0;

		Scanner keyboard = new Scanner(System.in);

		while (loop) {

			System.out.println("-1 <-- Para detener el programa!");
			System.out.println("Introduce la nota del examen:");
			nota = keyboard.nextInt();

			if (nota<0) {
				System.out.println("La nota media de todos los "+counter+" alumnos es: "+sumas/counter);
				System.out.println(" ");
				System.out.println("Hay: "+exc+" Excelentes, "+not+" Notables, "+bie+" Bienes, "+suf+" Suficientes, "+ins+" Insuficientes.");
				loop = false;
			} else if (counter==0) {
				System.out.println("No se han introducido notas");

			}
			
			switch (nota) {
			case 10:
				exc++;
				break;
			case 9:
			case 8:
				not++;
				break;
			case 7:
			case 6:
				bie++;
				break;
			case 5:
				suf++;
				break;
			default:
				ins++;
				break;
			}
			
			sumas+=nota;
			counter++;

		}

	}
}