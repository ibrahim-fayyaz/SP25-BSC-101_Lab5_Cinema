package sp25_bcs_101;

public class CityCinema{

	//Attributes
	String cityName;
	int numOfCinemas;

	// Large Array with logical counter
	Cinema cinemas[] = new Cinema[100];
	
	
	// Constructor
	public CityCinema(String name){
		cityName = name;
	}

	
	// Getters Methods
	public String getCityName(){
		return this.cityName;
	}

	public int getCinemaCount(){
		return this.numOfCinemas;
	}
	
 	public Cinema getCinema(String name){
		for(int i = 0; i < numOfCinemas;i++){
			if(cinemas[i].getCinemaName().equals(name)){
				return cinemas[i];
			}
		}
		return null;
	} 

	// Add Cinema
	public void addCinema(String name){
		cinemas[numOfCinemas++] = new Cinema(name);
	}

	// Remove Cinema 
	public void removeCinema(String name){
		for(int i = 0; i < numOfCinemas;i++){
			if(cinemas[i].getCinemaName().equals(name)){
				for(int j = i; j <  numOfCinemas -1; j++){
					cinemas[j] = cinemas[j + 1];
				}
				 numOfCinemas--;	
			} 
		}
	}

	//Preload Method
	public void initCinema(){
		cinemas[numOfCinemas++] = new Cinema("Universal");
		cinemas[numOfCinemas++] = new Cinema("Cinestar");
	}

	//Forward Booking from Cinnema -> Screen -> Seat
	public void forwardBooking(String cinemaName, String screenName, String seatId){
		for(int i = 0; i < numOfCinemas;i++){
			if(cinemas[i].getCinemaName().equals(cinemaName)){
				if (cinemas[i].forwardBooking(screenName,seatId)){
				System.out.println("Booking Seat ...");
				System.out.printf("%s > %s > %s > %s ____  " ,getCityName() ,cinemas[i].getCinemaName() , screenName , seatId);
				System.out.println("(Booked Successfully)");
				return;
				}
			else{
				System.out.println("Booking Seat ...");
				System.out.printf("%s > %s > %s > %s ____  " ,getCityName() ,cinemas[i].getCinemaName() , screenName , seatId);
				System.out.println("Booking Failed - \'The Seat is not Available\'");
				return;
				}	
			}
		}
		System.out.println("Invalid Cinema Name");
		
	} 

	//Forward Canceling from Cinnema -> Screen -> Seat
	public void forwardCanceling(String cinemaName, String screenName,String seatId){
		for(int i = 0; i < numOfCinemas;i++){
			if(cinemas[i].getCinemaName().equals(cinemaName)){
				if (cinemas[i].forwardCanceling(screenName,seatId)){
					System.out.println("Canceling Seat ...");
					System.out.printf("%s > %s > %s > %s ____  " ,getCityName() ,cinemas[i].getCinemaName() , screenName , seatId);
					System.out.println("(Cancelled Successfully)");
 					return;
				}
				else{
					System.out.println("Booking Seat ...");
					System.out.printf("%s > %s > %s > %s ____  " ,getCityName() ,cinemas[i].getCinemaName() , screenName , seatId);
					System.out.println("Canceling Failed - \'Either the Seat is Available or something went Wrong\'");
					return;
				
				}
			}	
		}
		
	         System.out.println("Invalid Cinema Name");
		
	} 

	//Total seats in the city
	public int totalSeats(){
		int total = 0;
		for(int i = 0; i < numOfCinemas;i++){
			total += cinemas[i].totalSeats();
		}
		return total;
	}

	//Total available seats
	public int totalAvailableSeats(){
		int total = 0;
		for(int i = 0; i < numOfCinemas;i++){
			total += cinemas[i].totalAvailableSeats();
		}
		return total;
	}

	//Total by seat type
	public int totalSeatsByType(SeatType type){
		int total = 0;
		for(int i = 0; i < numOfCinemas;i++){
			total += cinemas[i].totalSeatsByType(type);
		}
		return total;
	}

	// VIP Seat founder (Discovery method)
	public String vipSeatFinder(){
		Seat temp = null;
		Screen tempScreens[] = null;
		for(int i = 0; i < numOfCinemas;i++){
			tempScreens = cinemas[i].getScreenList();
			for(int j = 0; j < tempScreens.length; j++){
				temp = tempScreens[j].findFirstAvailable(SeatType.VIP);
				if( temp != null){
				System.out.println("\n=== VIP SEAT SEARCH ===");
				System.out.printf("First available VIP seat in %s: " ,getCityName());
				return String.format("%s  > %s > Seat %s (%s, %.1f PKR)" ,cinemas[i].getCinemaName(), tempScreens[j].getScreenName(), temp.getId(), temp.getSeatType(), temp.getPrice());}
			}
	
		}
		System.out.println("No VIP seat found");
		return null;				 			
	}

	// Display Report that outputs Complete Layout
	public void report(){
		System.out.println("\n**** CITY CINEMA REPORT ****");
		System.out.printf("%n=== CITY: %s | All Cinema Layouts ===%n" ,  getCityName());
		for(int i = 0; i < numOfCinemas;i++){
			System.out.printf("=== CINEMA: %s | Layouts ===%n" ,cinemas[i].getCinemaName());
			cinemas[i].display();
		}

	}

	// Override To String to display compact details
	@Override
	public String toString(){
		return String.format("| City: %s | Cinemas: %d | Total Seats: %d | Available: %d|", getCityName() , getCinemaCount() , totalSeats() ,totalAvailableSeats());
	}



}

	