public class CuentaPalabras {
    public static void main(String[] args) {

        String frase = "Cuantas palabras hay";
        String array[] = frase.split(" ");

        for (String a : array){
            System.out.println(a);
        }

        System.out.println("Hay un total de: "+array.length+" palabras.");
    }
}
