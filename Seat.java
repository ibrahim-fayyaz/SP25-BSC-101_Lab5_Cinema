public class Seat{

private String id;
private SeatType seatType;
private double price;
private boolean availability;

public Seat(String id , SeatType type , double price,boolean availability){
this.id = id ;
setSeatType(type);	
setPrice(price); 
this.availability = availability;
}

public boolean bookSeat(){
if(this.availability){
this.availability = false;
return true;
}
return false;
}

public String getId(){
return this.id;}

public SeatType getSeatType(){
return this.seatType;}

public boolean isAvailable(){
return this.availability;
}

public double getPrice(){
return this.price;}

public String toString(){
return String.format("SEAT [ID : %s, TYPE : %s, PRICE : %.2f, AVAILABILTY : %s]" , getId() , getSeatType()  , getPrice() , isAvailable() ? "YES" : "NO" );
}

public boolean cancelBooking(){
if(!this.availability){
this.availability = true;
return true;
}
return false;
}

public void setSeatType(SeatType type){
this.seatType = type;
}

public void setPrice(double price){
this.price = price;
}

public boolean equals(Seat other){
return this.id.equals(other.getId());
}

}

