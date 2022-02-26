import java.util.Iterator;

public class Diccionario {

	public static void main(String[] args) {

		for (char a1='a';a1<='z';a1++) {	
			for (char a2='a';a2<='z';a2++) {
				for (char a3='a';a3<='z';a3++) {
					for (char a4='a';a4<='z';a4++) {
						System.out.println(""+a1+a2+a3+a4);
					}
				}
			}
		}
		
	}
}