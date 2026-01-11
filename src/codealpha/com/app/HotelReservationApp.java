package codealpha.com.app;

import java.util.ArrayList;
import java.util.Scanner;

import codealpha.com.model.Reservation;
import codealpha.com.model.Room;
import codealpha.com.service.HotelService;

public class HotelReservationApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();

	public static void main(String[] args) {
		
	    // Creating rooms (Room Categorization)
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Standard", 2000));
        rooms.add(new Room(201, "Deluxe", 3500));
        rooms.add(new Room(301, "Suite", 5000));
        
        System.out.println("==================================");
		System.out.println(" HOTEL RESRVATION MANGMENT SYSTEM "); // Program title
		System.out.println("==================================");
 
	    while (true) {
            System.out.println("\n--- HOTEL RESERVATION SYSTEM ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();

            switch (choice) {
            case 1 -> viewRooms();
            case 2 -> bookRoom();
            case 3 -> HotelService.viewBookings();
            case 4 -> {
                System.out.println("Thank you for using the system!");
                return;
            }
            default -> System.out.println("Invalid choice!");
        }
		
		
	    }
	    
	    
	    
	}
	
	 // View available rooms
    static void viewRooms() {
        System.out.println("\n--- AVAILABLE ROOMS ---");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println(
                        "Room: " + r.roomNumber +
                        " | Category: " + r.category +
                        " | Price: ₹" + r.price
                );
            }
        }
    }
    
    // Book a room + payment simulation
    static void bookRoom() {

        sc.nextLine(); // clear buffer

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter room number: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {

            if (r.roomNumber == roomNo && !r.isBooked) {

                System.out.println("Amount to pay: ₹" + r.price);
                System.out.print("Confirm payment (yes/no): ");
                sc.nextLine();
                String pay = sc.nextLine();

                if (pay.equalsIgnoreCase("yes")) {

                    r.isBooked = true;

                    Reservation res = new Reservation(
                            name, r.roomNumber,
                            r.category, r.price
                    );

                    HotelService.saveBooking(res);

                    System.out.println("✅ Booking successful!");
                } else {
                    System.out.println("Payment cancelled!");
                }
                return;
            }
        }
        System.out.println("Room not available!");
    }

}
