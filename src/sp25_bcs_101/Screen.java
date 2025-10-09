package sp25_bcs_101;

public class Screen{
	
	// Fixed Default Prices
	private final double PRICE_REGULAR = 500;
	private final double PRICE_PREMIUM = 750;
	private final double PRICE_VIP = 1000;
	private final double PRICE_RECLINER = 1200;
	
	//Other Screen Attributes 
	private final static int DEFAULT_NUM_ROWS = 5;
	private Seat [][] seats = new Seat[DEFAULT_NUM_ROWS][];
	private String screenName;
	private int seatCount = 0;
	private static int nameCount = 1;
	private int[] rowLengths = new int[DEFAULT_NUM_ROWS]; 

	//Custom Screen Parameterized Constructor
	public Screen(String name , int [] rowLengths){
		this.screenName = name;
		this.rowLengths = rowLengths;
		initScreen();
	}

	//Default Constructor
	public Screen(){
		this.screenName = String.format("Screen-%d",nameCount++); 		
		this.rowLengths = buildDefaultRowLenghts(DEFAULT_NUM_ROWS);
		initScreen();
		if(nameCount > DEFAULT_NUM_ROWS) nameCount = 1;
	}

	//Preloading Screens
	private void initScreen(){
		for(int i = 0; i < this.rowLengths.length ; i++){
			seats[i] = new Seat[this.rowLengths[i]];
		}
		for(int i = 0; i < seats.length ; i++){
			for(int j = 0; j < seats[i].length ; j++){
				SeatType type; 
				Double price;
				if (i < 2){
					type = SeatType.REGULAR;
					price = PRICE_REGULAR;
				}

				else if(i < 3){
					type = SeatType.PREMIUM;
					price = PRICE_PREMIUM;
	
				}
	
				else if(i < 4){
					type = SeatType.VIP;
					price = PRICE_VIP;

				}
				else{
					type = SeatType.RECLINER;
					price = PRICE_RECLINER;
				}
				seats[i][j] = new Seat(String.format("%d-%03d",i,j), type , price);
				seatCount++;
			}
		}

	}

	// Cancel by Coordinates
	public boolean cancel(int row , int col){
		if(checkBounds(row,col)) {
			return seats[row][col].cancelBooking();
		}
		else {
			return false;
		}
	}

	// Cancel by Seat Id
	public boolean cancel(String id){
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.getId().equals(id)){ 
					return seat.cancelBooking();
				}
			}
		}
		return false;
	
	}

	//Book by coordinates
	public boolean book(int row , int col){
		if(checkBounds(row,col)) {
			return seats[row][col].bookSeat();
		}
		else {
			return false;
		}
	}

	//Book by id
	public boolean book(String id){
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.getId().equals(id)){ 
					return seat.bookSeat();
				}	
			}
		}
		return false;
	}
	
	// Getters Methods
	public int getRowLength(int r){
		return seats[r].length;
	}

	public int getRowCount(){
		return seats.length;	
	}

	public String getScreenName(){
		return screenName;
	}

	public int getTotalSeatCount(){
		return seatCount;
	}

	public Seat getSeat(String id){
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.getId().equals(id)){ 
					return seat;
				}
			}
		}
		return null;
	}

	public int getAvailableCount(){
		int count = 0;
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.isAvailable())	count++;
			}
		}
		return count;
	}

	public int getAvailableCount(SeatType type){
		int availableCount = 0;
		for(Seat[] row: seats){
			for(Seat seat: row){	
				if(seat.getSeatType().equals(type) && seat.isAvailable()){
					availableCount++;
				}
			}
		}
		return availableCount;
	}
	
	public int getSeatCountByType(SeatType type){
		int count = 0;
		for(Seat[] row: seats){
			for(Seat seat: row){	
				if(seat.getSeatType().equals(type)){
					count++;
				}
			}
		}
		return count;
	}

	//Modify Rows of 2D seats Array
	public void setRowType(int row, SeatType type , Double price){
		for(int i = 0;i<seats[row].length;i++){
			seats[row][i].setSeatType(type);
			seats[row][i].setPrice(price);
		}
	}

	// First Available Seat
	public Seat findFirstAvailable(SeatType type){
		for(Seat[] row: seats){
			for(Seat seat: row){	
				if(seat.getSeatType().equals(type) && seat.isAvailable()){
					return seat;
				}	
			}
		}
		return null;
	}

	

	// Availability by Seat Type
	public Seat[] listAvailable(SeatType type){
		int index = 0;
		Seat[] list = new Seat[getAvailableCount(type)];
		for(int i = 0; i < seats.length ; i++){
			for(int j = 0; j < seats[i].length ; j++){
				if(seats[i][j].getSeatType().equals(type) && seats[i][j].isAvailable()) list[index++] = seats[i][j];
				}
			}
		for(Seat s: list){ 
			System.out.println(s);
		}
		return list;
	}

	// Detailed Seats layout
	public void displayVerbose(){
		for(int i = 0; i < seats.length ; i++){
			//System.out.printf("	----- Row %d ----- %n" , i+1);
			for(int j = 0; j < seats[i].length ; j++){
				System.out.print(seats[i]);
			}
		}
	}

	// Compact Seats layout
	public void displayLayout(){
		for(int i = 0; i < seats.length ; i++){
			//System.out.printf("	----- Row %d ----- %n" , i+1);
			for(int j = 0; j < seats[i].length ; j++){
					System.out.printf("[%s:%s] " , seats[i][j].getId() , seats[i][j].isAvailable() ? "A" : "╳");
			
			}
			System.out.println();
		}
		System.out.printf("%nTotal: %s, Available: %s%n%n" , seatCount , getAvailableCount() );
	}


	// Private helpers methods provided by UML diagram

	private double priceFor(SeatType type){
		for(Seat[] row: seats)
			for(Seat seat: row)
				if(seat.getSeatType().equals(type))
					return seat.getPrice();
 		return 0;
	}

	private SeatType seatTypeFor(int row , int col){
		if(checkBounds(row ,col))
			return seats[row][col].getSeatType();
		else return null;
	}

	private int[] buildDefaultRowLenghts(int rowNum){
		int[] defaultLen = new int[rowNum];
		for(int i = 0; i < rowNum; i++){
			defaultLen[i] = 10+i;
		}
		return defaultLen;
	}

	private boolean checkRow(int row){
  		return row >= 0 && row < seats.length;

	}

	private boolean checkBounds(int row , int col){
		if(!checkRow(row)) return false;
    		if (col < 0 || col >= getRowLength(row)) {
       			return false;
    		}
    	 return true;
	}

}