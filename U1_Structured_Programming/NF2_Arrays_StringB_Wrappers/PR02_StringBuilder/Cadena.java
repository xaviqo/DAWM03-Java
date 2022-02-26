public class Cadena {
    public static void main(String[] args) {
        String palabra = "Cadena girada";

        System.out.println();
        
        for (int i = palabra.length()-1; i >= 0; i--) {
            char l = palabra.charAt(i);
            System.out.print(l);
        }
        System.out.println();
    }
}