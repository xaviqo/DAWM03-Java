import java.util.Scanner;

public class ArrayCalc {
    public static void main(String[] args) {
        //scanner
        Scanner kbd = new Scanner(System.in);

        //vars
        int[] numeros = new int[5];
        int opcion = 0;
        int total = 0;
        float totalDiv = 1;
        boolean menuBol = true;

        //pedir numeros al usuario
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Inserta el "+(i+1)+" número:");
            numeros[i] = kbd.nextInt();

        }

        //comienza bucle operativo
        do {
            //mensaje del menu
            System.out.println("Que operación quieres hacer?");
        System.out.println("1 - Sumar | 2 - Restar | 3 - Multiplicar | 4 - Dividir | 0 - Salir ");
        opcion = kbd.nextInt();

        //reininicia variables
        total = 0;

        //selector de operacion
        if (opcion == 0) {
            menuBol = false;
            System.out.println("El programa ha finalizado");
        } else if (opcion == 1) {
            for (int num : numeros) {
                total+=num;
            }
            System.out.println("Resultado: "+total);
        } else if (opcion == 2) {
            for (int num : numeros) {
                total-=num;
            }
            System.out.println("Resultado: "+total);
        } else if (opcion == 3) {
            total=1;
            for (int num : numeros) {
                total*=num;
            }
            System.out.println("Resultado: "+total);
        } else if (opcion == 4) {
            for (int num : numeros) {
                totalDiv/=num;
            }
            System.out.println("Resultado: "+totalDiv);
        } 

        } while (menuBol);
        kbd.close();
    }
}
