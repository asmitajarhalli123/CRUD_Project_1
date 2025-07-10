package org.example;

import java.sql.SQLException;
import java.util.Scanner;
import org.example.dbconnect.*;
import org.example.rooms.*;
import org.example.reservations.*;
import org.example.guest.*;


public class Main{

    public static void main(String args[]) throws SQLException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n-- Hotel Management Menu --");
            System.out.println("\n1. View Available Rooms");
            System.out.println("\n2. Check In Guest");
            System.out.println("\n3. Check Out Guest");
            System.out.println("\n4. List Reservations");
            System.out.println("\n5. Exit");
            System.out.print("\nEnter your Service: ");
            int choice = sc.nextByte();
            switch (choice) {
                case 1 -> rooms.view_Rooms();
                case 2 -> rooms.bookRoom();
                case 3 ->guest.Book_Out();
                case 4 -> reservations.listReservations();
                case 5 -> { System.out.println("Exiting... \nThank you !"); return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
