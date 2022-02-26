
public class Repeticions1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 100;
		int par = 0;
		int imp = 0;
		
		for (int i=0;i<=num;i++) {
			if (i%2==0) {
				par+=i;
			} else {
				imp+=i;
			}
		}
		System.out.println("La suma de numeros pares ha sido: "+par);
		System.out.println(" ");
		System.out.println("La suma de numeros impares ha sido: "+imp);
	}

}
