package sp25_bcs_101;

public class Seat{
	
	// Seat Class Attributes
	private String id;
	private SeatType seatType;
	private double price;
	private boolean availability;

	//Constructor
	public Seat(String id , SeatType type , double price){
		this.id = id ;
		setSeatType(type);	
		setPrice(price); 
		this.availability = true;
	}

	//Book Seat Method
	public boolean bookSeat(){
		if(this.availability){
			this.availability = false;
			return true;
		}
		return false;
	}
	
	//Cancel Seat Method
	public boolean cancelBooking(){
		if(!this.availability){
			this.availability = true;
			return true;
		}
		return false;
	}

	// Getters Methods
	public String getId(){
		return this.id;
	}

	public SeatType getSeatType(){
		return this.seatType;
	}

	public boolean isAvailable(){
		return this.availability;
	}

	public double getPrice(){
		return this.price;
	}

	// Set Type And Set Price Method
	public void setSeatType(SeatType type){
		this.seatType = type;
	}

	public void setPrice(double price){
		this.price = price;
	}

	// Overriden Methods
	public String toString(){
		return String.format("SEAT [ID : %s, TYPE : %s, PRICE : %.2f, AVAILABILTY : %s]" , getId() , getSeatType()  , getPrice() , isAvailable() ? "YES" : "NO" );
	}

	public boolean equals(Seat other){
		return this.id.equals(other.getId());
	}

}

