import java.util.Scanner;

public class BusTransfer implements Price {
	
	private int price;

	private static Scanner scan = new Scanner(System.in);
	
	public BusTransfer() {
		calculatePrice();
	}
	
	public int calculatePrice() {
		System.out.println("Do you want bus transfer? Y/N");
		int type = scan.next().charAt(0);
		if(type == 'y' || type == 'Y') {
			System.out.println("Do you want luxury bus transfer? Y/N");
			type = scan.next().charAt(0);
			if(type == 'y' || type == 'Y')
				price = 200;
			else
				price = 120;
		}
		else
			price = 0;
		return price;
	}
	
	public int getPrice() {
		return price;
	}
	
}
