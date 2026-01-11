package codealpha.com;

import java.util.Scanner;

public class HotelReservationManagementSystem {

	static boolean isRoomBooked = false; // This variable stores whether room is booked or not

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);

		System.out.println("==================================");
		System.out.println(" HOTEL RESRVATION MANGMENT SYSTEM "); // Program title
		System.out.println("==================================");

		while (true) {

			System.out.println("\n-------- MENU --------------- "); // Menu options
			System.out.println("1. Book Room ");
			System.out.println("2. Cnacel Reservtion");
			System.out.println("3. Check Booking Status");
			System.out.println("4. Exit");

			System.out.println("Enter Youer Choice: ");

			int choice = scr.nextInt(); // Stores user menu selection

			switch (choice) {

			case 1: // Book room logic

				if (!isRoomBooked) {

					isRoomBooked = true;

					System.out.println("✅ Room booked successfully! ");

				} else {

					System.out.println("⚠ Room alredy Booked ");
				}

				break;

			case 2: // Cancel booking logic

				if (isRoomBooked) {

					isRoomBooked = false;

					System.out.println("❌ Resrevetion Cancelld  ");

				} else {

					System.out.println("⚠ No booking found  ");
				}

				break;

			case 3: // Display booking status

				System.out.println("📌 Booking Status: " +

						(isRoomBooked ? "CONFIRMED" : "NOT BOOKED"));

				break;

			case 4: // Exit the program

				System.out.println("🙏 Thank you for using the system!");
				scr.close();
				return;

			default: // Invalid choice

				System.out.println("❌ Invalid choice! Try again.");

			}

		}

	}

}
