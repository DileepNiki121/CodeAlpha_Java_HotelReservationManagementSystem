package codealpha.com.model;

public class Room {
	
	public int roomNumber;
	public String category;
	public int price;
	public boolean isBooked;
	
	public Room(int roomNumber, String category, int price) {
		 this.roomNumber = roomNumber;
		 this.category = category;
		 this.price = price;
		 this.isBooked = false;
	}

}
