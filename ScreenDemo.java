public class ScreenDemo{
	public static void main(String[] args){

	Screen s = new Screen();
	
	s.book("3-010");
	s.book(0,0);
	System.out.println(s.getSeat("3-010"));
	System.out.println(s.getTotalSeatCount());
	System.out.println(s.getAvailableCount());
	s.cancel("3-010");
	s.cancel(3,1);
	System.out.println(s.findFirstAvailable(SeatType.REGULAR));
	System.out.println(s.getTotalSeatCount());
	System.out.println(s.getAvailableCount());
	s.listAvailable(SeatType.VIP);
	System.out.println(s.getRowCount());

	}
}