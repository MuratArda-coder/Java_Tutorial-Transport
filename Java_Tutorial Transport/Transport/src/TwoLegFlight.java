import java.util.Scanner;

public class TwoLegFlight extends Flight{
	
	private String secondDestination;
	private int secondDepartureTime;
	private int secondArrivalTime;
	private int secondTimeZoneDifference;
	
	private int duration;
	
	private static Scanner scan = new Scanner(System.in);
	
	public TwoLegFlight() {
		
		super();

		System.out.print("SecondDestination:");
		secondDestination=scan.next();
		
		System.out.print("SecondDepartureTime:");
		secondDepartureTime=scan.nextInt();
		
		System.out.print("SecondArrivalTime:");
		secondArrivalTime=scan.nextInt();
		
		System.out.print("SecondTimeZoneDifference:");
		secondTimeZoneDifference=scan.nextInt();
				
	}
	@Override
	public int calculateDuration() {
		duration=super.calculateDuration() + (secondArrivalTime-secondDepartureTime+secondTimeZoneDifference);
		return duration;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public int calculatePrice() {
		return getDuration()*90;
	}
	
	@Override
	public int totalTimeDifference() {
		return super.totalTimeDifference()+secondTimeZoneDifference;
	}
	
	@Override
	public void displayInfo() {
		System.out.print("	origin:"+super.getOrigin());
		System.out.print("	secondDestination:"+secondDestination);
		System.out.println("	secondDepartureTime:"+secondDepartureTime);
		System.out.print("	secondArrivalTime:"+secondArrivalTime);
		System.out.print("	secondTimeZoneDifference:"+totalTimeDifference());
		System.out.print("\tDuration:"+duration);
	}
}
