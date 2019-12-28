import java.util.Scanner;

public class ThreeLegFlight extends TwoLegFlight{

	private String ThirdDestination;
	private int ThirdDepartureTime;
	private int ThirdArrivalTime;
	private int ThirdTimeZoneDifference;
	
	private int duration;
	
	private static Scanner scan = new Scanner(System.in);
	
	public ThreeLegFlight() {
		
		super();

		System.out.print("ThirdDestination:");
		ThirdDestination=scan.next();
		
		System.out.print("ThirdDepartureTime:");
		ThirdDepartureTime=scan.nextInt();
		
		System.out.print("ThirdArrivalTime:");
		ThirdArrivalTime=scan.nextInt();
		
		System.out.print("ThirdTimeZoneDifference:");
		ThirdTimeZoneDifference=scan.nextInt();
		
	}
	
	@Override
	public int calculateDuration() {
		duration=super.calculateDuration() + (ThirdArrivalTime-ThirdTimeZoneDifference+ThirdTimeZoneDifference);
		return duration;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public int calculatePrice() {
		return getDuration()*85;
	}
	
	@Override
	public int totalTimeDifference() {
		return super.totalTimeDifference()+ThirdTimeZoneDifference;
	}
	
	@Override
	public void displayInfo() {
		System.out.print("	origin:"+super.getOrigin());
		System.out.print("	ThirdDestination:"+ThirdDestination);
		System.out.println("	ThirdDepartureTime:"+ThirdDepartureTime);
		System.out.print("	ThirdArrivalTime:"+ThirdArrivalTime);
		System.out.print("	ThirdTimeZoneDifference:"+totalTimeDifference());	
		System.out.print("\tDuration:"+duration);
	}
}
