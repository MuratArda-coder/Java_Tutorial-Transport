import java.util.Scanner;

public class Flight implements Price{

	private String origin;
	private String destination;
	private int departureTime;
	private int arrivalTime;
	private int timeZoneDifference;
	
	private int duration;
	
	private static Scanner scan = new Scanner(System.in);
	
	public Flight() {
		
		System.out.print("Origin:");
		origin=scan.next();
		
		System.out.print("Destination:");
		destination=scan.next();
		
		System.out.print("DepartureTime:");
		departureTime=scan.nextInt();
		
		System.out.print("ArrivalTime:");
		arrivalTime=scan.nextInt();
		
		System.out.print("TimeZoneDifference:");
		timeZoneDifference=scan.nextInt();
		
	}
	
	public int calculateDuration() {
		duration=arrivalTime-departureTime+timeZoneDifference;
		return duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int calculatePrice() {
		return getDuration()*100;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public int totalTimeDifference() {
		return timeZoneDifference;
	}
	
	public void displayInfo() {
		System.out.print("	origin:"+origin);
		System.out.print("	destination:"+destination);
		System.out.println("	departureTime:"+departureTime);
		System.out.print("	arrivalTime:"+arrivalTime);
		System.out.print("	timeZoneDifference:"+totalTimeDifference());
		System.out.print("\tDuration:"+duration);
	}
	
}
