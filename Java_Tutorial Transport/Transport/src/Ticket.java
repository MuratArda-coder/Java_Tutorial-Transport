import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ticket  implements Comparable<Ticket> {

	private String seatNumber;
	private Flight flight;
	private static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private BusTransfer bus;
	private String passengerName;
	
	private Map<String,String> passengerMap;
	
	private Scanner scan = new Scanner(System.in);
	
	private int price;
	private FlightClass type;
	private char typeClass;
	
	public Ticket() {}
	
	public Ticket(int flyStyle) {
		
		MakePassengerMap();
		
		System.out.print("Passenger Name:");
		passengerName = scan.next();
		if(flyStyle==1)
			flight=new Flight();
		else if(flyStyle==2)
			flight=new TwoLegFlight();
		else if(flyStyle==3)
			flight=new ThreeLegFlight();
		
		System.out.println("Choose your Ticket Type:");
		System.out.println("Please Type \"E\" for Economy, \"B\" for Business and \"F\" for First Class");
		
		typeClass = scan.next().charAt(0);
		typeClass = Character.toUpperCase(typeClass);
		
		switch(typeClass) {
			case 'E':
				type = FlightClass.Economy;
				break;
			case 'B':
				type = FlightClass.Business;
				break;
			case 'F':
				type = FlightClass.First_Class;
				break;
		}
		
		bus = new BusTransfer();

		System.out.print("SeatNumber:");
		seatNumber=scan.next();
	}
	
	public void MakePassengerMap() {
		String username;
		String password;
		System.out.print("Enter username:");
		username = scan.next();
		while(FindErrorName(username)) {
			System.out.println("Username does not meet the minimum requirements.");
			System.out.print("Enter username:");
			username = scan.next();
		}
		System.out.print("Enter password:");
		password = scan.next();
		while(FindErrorId(password)) {
			System.out.println("Password does not meet the minimum requirements.");
			System.out.print("Enter Password:");
			password = scan.nextLine();
		}
		passengerMap = new HashMap<>();
		passengerMap.put(username,password);
	}
	
	public boolean FindErrorId(String Id) {
		
		if(Id.length()<8)
			return true;
		else if(Id.contains(" "))
			return true;
		
		return false;
	}

	public boolean FindErrorName(String name) {
		
		if(name.length()<8)
			return true;
		else if(name.charAt(0)<='9' && name.charAt(0)>='0')
			return true;
		
		return false;
	}

	public void createTicket(int flyStyle) {		
		ticketList.add(new Ticket(flyStyle));
		ticketList.get(ticketList.size()-1).flight.calculateDuration();
	}
	
	public void displayInfo() {
		Collections.sort(ticketList);
		System.out.println("1)Ascending Order");
		System.out.println("2)Descending Order");
		int type=scan.nextInt();
		if(type==1) {
			for(int i=0;i<ticketList.size();i++) {
				System.out.println("Passenger Name:"+ticketList.get(i).passengerName);
				ticketList.get(i).flight.displayInfo();
				System.out.println("SeatNUmber:"+ticketList.get(i).seatNumber);
				System.out.println("Flight Style:"+ticketList.get(i).type);
			}
		}
		else if(type==2) {
			for(int i=ticketList.size()-1;i>=0;i--) {
				System.out.println("Passenger Name:"+ticketList.get(i).passengerName);
				ticketList.get(i).flight.displayInfo();
				System.out.println("SeatNUmber:"+ticketList.get(i).seatNumber);
				System.out.println("Flight Style:"+ticketList.get(i).type);
			}
		}
		else
			System.out.println("Invalid Token!!!");
	}
	
	public void calculatePrices() {
		int totalPrice=0;
		for(int i=0;i<ticketList.size();i++) {
			ticketList.get(i).price=ticketList.get(i).flight.calculatePrice()+ticketList.get(i).bus.getPrice();
			System.out.print("Passenger Name:"+ticketList.get(i).passengerName);
			System.out.println("	price:"+ticketList.get(i).price);
			totalPrice=totalPrice+ticketList.get(i).price;
		}
		System.out.println("TotalPrice is:"+totalPrice);
		
	}
	
	public int compareTo(Ticket tck){  
		 
		 if(seatNumber==tck.seatNumber)
			 return 0;
		 else if(seatNumber.compareTo(tck.seatNumber)>0)
			 return 1;
		 else
			 return -1;
		 
	}

	public void DisplayUser() {
		
		for(int i=0;i<ticketList.size();i++) {
			System.out.println(ticketList.get(i).passengerMap.keySet());
		}
		
	}
	
}
