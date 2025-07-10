package org.example;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.example.dbconnect.*;





public class rooms {
    // viewing rooms (reading operation)
    public static void view_Rooms() {
        try (Connection con = dbconnect.getConnection(); Statement st = con.createStatement();) {
            String query = "select * from rooms where isAvailable = FALSE;";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt("id") + "|" + rs.getString("room_number")  + "|" + rs.getString("type") + "|" + rs.getInt("price") + "|" + rs.getBoolean("isAvailable"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//view_Rooms

    // Booking a Room (Inserting values)
    public static void bookRoom(){
        Scanner sc = new Scanner(System.in);
        // get guest id to book a room

        System.out.println("enter room number:");
        int roomid = sc.nextInt();
        System.out.println("Gust Name :");
        String name = sc.next();
        System.out.println("Gust email:");
        String email = sc.next();
        System.out.println("Room Check in Date(yyyy-MM-dd) :");
        String dateIn = sc.next();
        System.out.println("Room Check out Date(yyyy-MM-dd) :");
        String dateOut = sc.next();


        String insertInGuest = "insert into guests( name , email) values (?,?);";
        String updateInRoom = "update rooms set isAvailable = true where id = ?;";
        String insertInRes = "insert into reservations(check_in , check_out) values(?,?);";


        try(Connection con = dbconnect.getConnection();){
            int gid = 0;

            try(PreparedStatement pg = con.prepareStatement(insertInGuest)){
                pg.setString(1,name);
                pg.setString(2, email);
                pg.executeUpdate();

            }

            try(PreparedStatement pr = con.prepareStatement(insertInRes)){


                pr.setDate(1 , java.sql.Date.valueOf(dateIn));
                pr.setDate(2 , java.sql.Date.valueOf(dateOut));
               pr.executeUpdate();
            }

            try(PreparedStatement ur = con.prepareStatement(updateInRoom)){

                ur.setInt(1 ,roomid);
                ur.executeUpdate();
            }

            System.out.println("Dear Gust your Room Booked Successfully !! Thank you for connecting with us .");

        }
        catch (SQLException e){ e.printStackTrace();}

    }//bookRoom
}
