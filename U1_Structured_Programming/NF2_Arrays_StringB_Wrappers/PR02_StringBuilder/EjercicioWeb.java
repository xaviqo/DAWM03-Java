public class EjercicioWeb {
    public static void main(String[] args) {
        
        StringBuilder frase = new StringBuilder("Hola Caracola");
        int numero = 5000;
        

        System.out.println("El tamaño del SB es de "+frase.length()+" bytes");
        System.out.println();
        System.out.println("El largo del SB es de "+frase.capacity()+" carácteres");
        System.out.println();

        frase = frase.replace(frase.indexOf("Hola"), "hola".length(), "Hay");

        System.out.println(frase);
        System.out.println();

        frase.append("s");
        frase = frase.insert(3, " ");
        frase = frase.insert(4, numero);

        System.out.println(frase);
        System.out.println();

        frase.append(" en el mar!");

        System.out.println(frase);
        System.out.println();

        String mar = frase.substring(frase.length()-4,frase.length());
        
        System.out.println(mar);
        

    }
}
