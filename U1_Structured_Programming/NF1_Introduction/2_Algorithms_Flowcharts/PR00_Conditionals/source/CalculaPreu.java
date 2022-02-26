import java.util.Scanner;

public class CalculaPreu {

	public static void main(String[] args) {
		
		// inicio de variables
		int quantitat = 0;
		double priceUnit = 0;
		double priceTotal = 0;
		String descompteNum = "0%";
		String descompteText = "";
		boolean descompteBool = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Quantitat: ");
		quantitat = keyboard.nextInt();
		
		System.out.print("Preu del producte: ");
		priceUnit = keyboard.nextDouble();
		
		//calcular precio sin calcular descuento
		
		priceTotal=priceUnit*quantitat;
		
		//comprueba si se aplica descuento (y cual aplicamos)
		
		if (priceTotal>1000) {
			
			// cambios en variables
			descompteBool = true;
			descompteNum = "40%";
			descompteText = "1000€";
			
			// calcular descuento 40% de unidad
			priceTotal=priceTotal-(priceTotal*0.4);

		} else if (priceTotal>500) {
			
			// cambios en variables
			descompteBool = true;
			descompteNum = "20%";
			descompteText = "500€";
			
			// calcular descuento 20% de unidad
			priceTotal=priceTotal-(priceTotal*0.2);
	
			}
		
		
		// comprueba si se ha aplicado descuento y que texto mostramos
		if (descompteBool==true) {
			
			System.out.println("Has pedido de "+quantitat+"Uds a "+priceUnit+" cada una. Sumando un total de "+priceUnit*quantitat+"€");
			System.out.println("Al hacer un pedido superior a "+descompteText+" se ha aplicado un descuento del "+descompteNum);
			System.out.println("Por lo tanto, el precio final será de "+priceTotal+"€");
			
		} else if (descompteBool==false) {
			
			System.out.println("Has pedido de "+quantitat+"Uds a "+priceUnit+" cada una. Sumando un total de "+priceUnit*quantitat+"€");
			System.out.println("Tu pedido es inferior al precio mínimo, por lo tanto, no se aplicará el descuento.");
			System.out.println("El precio final será de "+priceTotal+"€");
			
		}
		
		
	}
	
	
}
