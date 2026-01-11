package codealpha.com.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import codealpha.com.model.Reservation;

public class HotelService {

	public static final String FILE_NAME = "bookings.txt";
	
	
	public static void saveBooking(Reservation r) {
		
		 try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
			  fw.write(r.customerName + "," +
	                     r.roomNumber + "," +
	                     r.category + "," +
	                     r.amountPaid + "\n");
			 
			  
		  } catch (IOException e) {
	            System.out.println("File error occurred!");
	        }
		
	}
	
	 public static void viewBookings() {
		 

	        try (BufferedReader br =
	                     new BufferedReader(new FileReader(FILE_NAME))) {

	            String line;
	            System.out.println("\n--- BOOKING DETAILS ---");

	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                System.out.println(
	                        "Name: " + data[0] +
	                        " | Room: " + data[1] +
	                        " | Category: " + data[2] +
	                        " | Paid: ₹" + data[3]
	                );
	            }

	        } catch (IOException e) {
	            System.out.println("No bookings found!");
	        }
		 
	 }
	
}
