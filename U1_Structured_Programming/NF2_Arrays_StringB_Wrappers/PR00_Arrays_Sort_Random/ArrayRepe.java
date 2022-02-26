import java.util.Random;
import java.util.Scanner;

public class ArrayRepe {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Random random = new Random();

        // vars
        int arrayLong = 0;
        boolean primerPaso = false;
        int paso = 1;
        int repetidos = 1;
        int faltan = 0;

        while (true) {

            // introducir num
            System.out.print("Largo del Array: ");
            arrayLong = kbd.nextInt();
            System.out.println(" ");

            if (arrayLong > 0 && arrayLong < 101) {

                int[] arrayNums = new int[arrayLong];

                // introduce numeros rnd al array
                for (int i = 0; i < arrayLong; i++) {

                    arrayNums[i] = random.nextInt(20+1);

                    faltan = arrayLong-paso;

                    System.out.println("# - PUSHED_NUM: ["+arrayNums[i]+"] | REMAIN: "+faltan+" | ACTUAL_POS: ["+i+"]");

                    if (primerPaso) { //evitar que compruebe primera vez

                        // comprueba numeros repetidos
                        for (int j = 0 ; j < i; j++) {

                            if (arrayNums[i] == arrayNums[j]) {

                                //control de repeticiones
                                System.out.println("! - REPEATED: ["+arrayNums[i]+"] | DETECTED_POS: ["+j+"] | TOTAL_REP: ["+repetidos+"]");
                                repetidos++;
                                break;

                            } 
                        }
                    }
                    primerPaso = true;
                    paso++;
                }
            }
            kbd.close();
            break;
        }

    }
}
