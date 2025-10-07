public class Screen{
	
	private final double PRICE_REGULAR = 500;
	private final double PRICE_PREMIUM = 750;
	private final double PRICE_VIP = 1000;
	private final double PRICE_RECLINER = 1200;
	private final static int DEFAULT_NUM_ROWS = 5;
	private Seat [][] seats = new Seat[DEFAULT_NUM_ROWS][];
	private String screenName;
	private int seatCount = 0;
	private static int nameCount = 1;
	private int[] rowLengths = new int[DEFAULT_NUM_ROWS]; 

	public Screen(String name , int [] rowLengths){
		this.screenName = name;
		this.rowLengths = rowLengths;
		initScreen();
	}

	public Screen(){
		this.screenName = String.format("Screen %d",nameCount++); 		
		this.rowLengths = buildDefaultRowLenghts(DEFAULT_NUM_ROWS);
		initScreen();
		if(nameCount > DEFAULT_NUM_ROWS) nameCount = 1;
	}

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
				seats[i][j] = new Seat(String.format("%d-%03d",i,j), type , price , true);
				seatCount++;
			}
		}

	}

	public boolean cancel(int row , int col){
		if(checkBounds(row,col)) {
			return seats[row][col].cancelBooking();
		}
		else {
			return false;
		}
	}

	public boolean cancel(String id){
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.getId().equals(id) && !seat.isAvailable()){ 
					return seat.cancelBooking();
				}
			}
		}
		return false;
	
	}

	public boolean book(int row , int col){
		if(checkBounds(row,col)) {
			return seats[row][col].bookSeat();
		}
		else {
			return false;
		}
	}

	public boolean book(String id){
		for(Seat[] row: seats){
			for(Seat seat: row){
				if(seat.getId().equals(id) && seat.isAvailable()){ 
					return seat.bookSeat();
				}	
			}
		}
		return false;
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

	public void setRowType(int row, SeatType type , Double price){
		for(int i = 0;i<seats[row].length;i++){
			seats[row][i].setSeatType(type);
			seats[row][i].setPrice(price);
		}
	}

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

	public int getRowLength(int r){
		return seats[r].length;
	}

	public int getRowCount(){
		return seats.length;	
	}

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


	public void displayVerbose(){
		for(Seat[] row: seats){
			for(Seat seat: row){	
				System.out.println(seat);
			}
		}
	}

	public void displayLayout(){

		for(int i = 0; i < seats.length ; i++){
			System.out.printf("	----- Row %d ----- %n" , i+1);
			for(int j = 0; j < seats[i].length ; j++){
					System.out.printf("[ID: %s AVAILABILITY: %s] - " , seats[i][j].getId() , seats[i][j].isAvailable() ? "YES" : "NO");
			
			}
		System.out.println();
		}
	}


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