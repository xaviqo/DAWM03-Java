import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Mayus {

    public static File file = null;
    public static FileReader fr = null;
    public static BufferedReader br = null;
    public static ArrayList<String> lineasFile = new ArrayList<>();
    public static PrintWriter pw = null;

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir") + "/";

        System.out.println("Tu directorio actual es: " + dir);
        System.out.print("Que archivo quieres convertir a mayúsculas? ");
        String fileStr = UtilConsole.inputString();
        System.out.print("Nombre del nuevo archivo? ");
        String newFileStr = UtilConsole.inputString();

        try {

            pw = new PrintWriter(new FileWriter(newFileStr));
            file = new File(dir + fileStr);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
            System.out.println("El archivo " + fileStr + " no existe! ");

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("No se ha podido crear el archivo " + newFileStr);
        }

        for (String linea : lineasToArray()) {
            pw.println(linea);
            System.out.println(linea);
        }

        try {
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static ArrayList<String> lineasToArray() {

        try {
            String line;
            while ((line = br.readLine()) != null) {
                lineasFile.add(line.toUpperCase());

            }
            if (fr != null) fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return lineasFile;
    }
}
