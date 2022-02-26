public class SBTrim {

    public static void main(String[] args) {

        String palabra = "Hola    que     tal";
        StringBuilder str = new StringBuilder(palabra);

        /* con regex
        String noSpace = str.toString().trim().replaceAll(" +", " ");
        System.out.println(noSpace);
        */
        
        for (int i = 0; i < str.length(); i++) {            
            
            if (str.charAt(i) == ' ' && str.charAt(i+1) == ' ') {
                str.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(str.toString());
    }
}