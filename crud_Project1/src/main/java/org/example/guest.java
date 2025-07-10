package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DriverManager;
import java.util.Date;
import org.example.dbconnect.*;
import java.sql.*;


public class guest {


    public static void Book_Out() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to check out: ");
        int id = sc.nextInt();
        System.out.print("Enter Room Id :");
        int roomID = sc.nextInt();
        String updateRes = "update reservations set check_out = CURRENT_DATE where id = ? ";
        String updateRoom = "update rooms set isAvailable = FALSE where room_id=?";
        try (Connection con = dbconnect.getConnection()) {
            try (PreparedStatement ur = con.prepareStatement(updateRes)) {
                ur.setInt(1,id);
                ur.executeUpdate();
                try (PreparedStatement or = con.prepareStatement(updateRoom)) {
                    or.setInt(1, roomID);
                    or.executeUpdate();
                }catch (SQLException e){}
                System.out.println("You are Checked out Successfully !! Thank you for connecting with us.");
            }
            catch (SQLException e) {
                e.printStackTrace();
        }

        }// Book_Out
}




            }