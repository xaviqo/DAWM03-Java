import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rajoyer {

    public static final String dir = "/Desktop/WINDOWS/CURSOS/DAW/M03_PROGRAMACION/UF3/PR01";
    public static final String fileW = "rajoy.txt";
    public static final String fileR = "frases.txt";
    public static ArrayList<String> frasesRajoy = new ArrayList<>();
    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static long peticionUsuario = 0;
    public static PrintWriter pw = null;
    public static FileReader fr = null;

    public static void main(String[] args) {

        frasesToArray();

        try {

            pw = new PrintWriter(new FileWriter(fileW));

            System.out.print("Cuantas frases aleatorias de rajoy quieres? ");
            peticionUsuario = sc.nextLong();

            while (peticionUsuario > 0) {
                pw.println(frasesRajoy.get(random.nextInt(frasesRajoy.size())));

                peticionUsuario--;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                pw.close();
                } catch (Exception e) {
                System.out.println(e);
                }

        }

    }

    private static void frasesToArray() {

        try {
            fr = new FileReader(fileR);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                frasesRajoy.add(line);
            }
            if (fr != null) fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
