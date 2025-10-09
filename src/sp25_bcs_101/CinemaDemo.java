package sp25_bcs_101;

public class CinemaDemo {
    public static void main(String[] args) {
       

        // Initializing CityCinema Objects
        CityCinema karachi = new CityCinema("Karachi");
        CityCinema lahore  = new CityCinema("Lahore");
        CityCinema islamabad = new CityCinema("Islamabad");

        // Preload with realistic cinemas
        karachi.addCinema("Atrium Saddar");
        karachi.addCinema("Nueplex DHA");
        lahore.addCinema("CineStar Township");
        lahore.addCinema("CineStar Gulberg");
        islamabad.addCinema("Centaurus Megaplex");


       //Display CityCinema Layouts
        System.out.println(">>> Initial layouts of all cities:\n");
        karachi.report();
        lahore.report();
        islamabad.report();



        //Workflow Simulation
        System.out.println("\n========= WORKFLOW SIMULATION =========");

        // Book seat 3-007 in Karachi > Atrium Saddar (Cinema-1) > Screen-1
        System.out.println("\nBooking Seat 3-007 in Karachi (Atrium Saddar, Screen-1)...");
        karachi.forwardBooking("Atrium Saddar", "Screen-1", "3-007");

        // Attempt same seat again
        System.out.println("Attempting to book the same seat again (should reject)... ");
        karachi.forwardBooking("Atrium Saddar", "Screen-1", "3-007");

        // Cancel booking
        System.out.println("Canceling booking for 3-007...");
        karachi.forwardCanceling("Atrium Saddar", "Screen-1", "3-007");


        //Updated Display layout of Karachi CityCinema
        System.out.println("\n>>> Updated Layout of Karachi after booking + cancel:");
        karachi.report();


        //VIP Seat Search
        System.out.println(lahore.vipSeatFinder());

        //Final Summary
        System.out.println("\n========= FINAL SUMMARY =========");
        System.out.println(karachi);
        System.out.println(lahore);
        System.out.println(islamabad);


        System.out.println("\n========= CINEMA DEMO COMPLETE =========");
    }
}

   
