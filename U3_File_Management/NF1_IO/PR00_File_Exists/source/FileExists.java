import java.io.*;

public class FileExists {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir") + "/";

        System.out.println("Tu directorio actual es: " + dir);
        System.out.print("Que archivo quieres leer? ");
        String fileStr = UtilConsole.inputString();

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;


        try {

            file = new File(dir + fileStr);
            fr = new FileReader(file);

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
            System.out.println("El archivo " + fileStr + " no existe! ");
        }

        if (file.length() < 1) {
            System.out.println("El archivo está vacío!");
            return;
        }

        try {

            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
