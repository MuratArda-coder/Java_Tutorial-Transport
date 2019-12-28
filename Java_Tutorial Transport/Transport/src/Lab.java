import java.util.Scanner;

public class Lab {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int command;
		int type;
		Ticket ticket = new Ticket();

		Menu.menu();
		command = scan.nextInt();
		while (command!=0) {
			if(command==1) {
				Menu.planeStyle();
				type=scan.nextInt();
				ticket.createTicket(type);
				System.out.println("Flight Created");
			}
			if(command==2)
				ticket.displayInfo();
			if(command==3)
				ticket.calculatePrices();
			if(command==4)
				ticket.DisplayUser();
			
			Menu.menu();
			command = scan.nextInt();
		}
		System.out.println("System Terminated!!!");
	}

}

class Menu {
	static void menu() {
		System.out.println("1.Create new Flight with Seat Number");
		System.out.println("2.Display all Flights according to Seat Number");
		System.out.println("3.Calculate Prices");
		System.out.println("4.Display all username of boarders");
		System.out.println("0.Exit");
	}
	static void planeStyle() {
		System.out.println("1.Create a Non-Stop Flight");
		System.out.println("2.Create a Two-Leg Flight");
		System.out.println("3.Create a Three-Leg Flight");
	}
	
}