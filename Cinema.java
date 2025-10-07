public class Cinema{

private Screen screens[];
private String cinemaName;
private int[] customRowLengths = {6, 12, 12 , 12 ,10};

	public Cinema(String name , int numOfScreens){
	
	screens = new Screen[numOfScreens];
	for(int i = 0 ; i < numOfScreens-1; i++){
		screens[i] = new Screen();

		}
	screens[numOfScreens-1] = new Screen("Custom" , customRowLengths);
	
}

	public void display(){
	for(Screen screen: screens){
		System.out.println("\n==================== "+screen.getScreenName()+" ====================\n");
		screen.displayLayout();
		}

	}
}
