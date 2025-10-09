package sp25_bcs_101;

public class Cinema{

	// Cinema Attributes
	private Screen screens[] = new Screen[100];
	private String cinemaName;
	private int numOfScreens = 5;

	//Constructor
	public Cinema(String name){
	cinemaName = name;
		for(int i = 0 ; i < numOfScreens; i++){
			screens[i] = new Screen();
		}
	}

	// Getters Methods
	public String getCinemaName(){
		return this.cinemaName;
	}

	public int getScreenCount(){
		return this.numOfScreens;
	}

	public Screen[] getScreenList(){
		Screen[] s = new Screen[numOfScreens];
		for(int i = 0; i < numOfScreens; i++){
			s[i] = screens[i];
		}
		return s;
	}

	public Screen getScreen(String name){
		for(Screen screen: screens){
			if(screen != null && screen.getScreenName().equals(name)){
				
				return screen;
			} 
		}
		return null;
	}

	
	// Custom Screen with parameterised Constructor
	public void customScreen(String name , int[] customRowLengths){
	if(numOfScreens > screens.length)
	screens[numOfScreens++] = new Screen(name , customRowLengths);
}
	
	// Display Layout
	public void display(){
	for(Screen screen: screens){
		if(screen != null){
		System.out.println("==== "+screen.getScreenName()+" | Layout ===");
		screen.displayLayout();
			}
		}

	}

	// Display Verbose
	public void detailedDisplay(){
	for(Screen screen: screens){
		if(screen != null){
		System.out.println("\n=== "+screen.getScreenName()+" ====\n");
		screen.displayVerbose();
			}
		}

	}

	
	// forward booking method (String name , String id)
	public boolean forwardBooking(String name , String id){
		for(int i = 0; i < numOfScreens; i++){
			if(screens[i].getScreenName().equals(name)){
				return screens[i].book(id);
			}
		}
		return false;
	}

	// forward canceling method (String name , String id)
	public boolean forwardCanceling(String name , String id){
		for(int i = 0; i < numOfScreens; i++){
			if(screens[i].getScreenName().equals(name)){
				return screens[i].cancel(id);
			}
		}
		return false;
	}
	

	// Total Seats of cinema
	public int totalSeats(){
		int total = 0;
		for(int i = 0; i < numOfScreens; i++){
			total += screens[i].getTotalSeatCount();
		}
		return total;
	}

	// Total Available Seats of cinema
	public int totalAvailableSeats(){
		int total = 0;
		for(int i = 0; i < numOfScreens; i++){
			total += screens[i].getAvailableCount();
		}
		return total;
	}

	// Total Seats of cinema by Seat Type
	public int totalSeatsByType(SeatType type){
		int total = 0;
		for(int i = 0; i < numOfScreens; i++){
			total += screens[i].getSeatCountByType(type);
		}
		return total;
	}

	// Total Available Seats of cinema by Seat Type
	public int totalAvailableByType(SeatType type){
		int total = 0;
		for(int i = 0; i < numOfScreens; i++){
			total += screens[i].listAvailable(type).length;
		}
		return total;
	}

	//Overriden To String Method 
	@Override
	public String toString(){
		return String.format("Name: %s, Number of Screens: %d, Total Seats: %d, Available Seats %d" , this.cinemaName, numOfScreens ,  totalSeats() , totalAvailableSeats());

	}

}
