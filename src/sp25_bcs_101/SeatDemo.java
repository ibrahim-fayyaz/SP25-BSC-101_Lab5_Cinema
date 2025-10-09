package sp25_bcs_101;

public class SeatDemo{
	
	public static void main(String[] args) {
        System.out.println("=== Seat Demo: Testing Seat Functionality ===\n");
	
	// Seat Objects
        Seat regular = new Seat("1-001", SeatType.REGULAR, 500);
        Seat premium = new Seat("2-002", SeatType.PREMIUM, 750);
        Seat vip = new Seat("3-003", SeatType.VIP, 1000);
        Seat recliner = new Seat("4-004", SeatType.RECLINER, 1200);

	//Initial Seat before Booking
        System.out.println("Initial Seat States:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);

	//Using Booking Method 
        System.out.println("\n=== Booking Regular and VIP seats ===");
        regular.bookSeat();
        vip.bookSeat();

	//Availability After using Booking Method
        System.out.println("\nAfter Booking:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);

	//Attempting Again
        System.out.println("\n=== Attempting to book VIP seat again ===");
        boolean bookedAgain = vip.bookSeat();
        System.out.println(bookedAgain ? "Booking succeeded (unexpected)" : "Booking rejected (already booked)");

	//Using Cancelling Method
        System.out.println("\n=== Canceling VIP seat ===");
        vip.cancelBooking();

	//After Cancellation 
        System.out.println("\nAfter Cancellation:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);

	//Increasing Price
        System.out.println("\n=== Increasing Premium seat price by 100 PKR ===");
        premium.setPrice(premium.getPrice() + 100);

        System.out.println("\nAfter Price Update:");
        System.out.println(regular);
        System.out.println(premium);
        System.out.println(vip);
        System.out.println(recliner);

	// To String Display
        System.out.println("\n=== Summary ===");
        Seat[] allSeats = { regular, premium, vip, recliner };
        for (Seat s : allSeats) {
            System.out.println(s);
        }

        System.out.println("\n=== End of Seat Demo ===");
    }


}