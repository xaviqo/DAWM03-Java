import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        
        Scanner kbd = new Scanner(System.in);
        long number = 0;

        do {

            System.out.print("Introduce un número (Max: "+Integer.MAX_VALUE+"): ");
            number = kbd.nextLong();

        } while (number < 0 || number > Integer.MAX_VALUE);

        System.out.println("Num: "+number);

        kbd.close();
    }
}
