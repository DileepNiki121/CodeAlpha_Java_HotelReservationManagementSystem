package codealpha.com.model;

public class Reservation {
	public String customerName;
	public int roomNumber;
	public String category;
	public int amountPaid;
	
	public Reservation(String customerName, int roomNumber,
			            String category, int amountPaid) {
	  this.customerName = customerName;
	  this.roomNumber = roomNumber;
	  this.category = category;
	  this.amountPaid = amountPaid;
		
		
	}
	

}
