package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import org.example.dbconnect.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class reservations {


    public static void listReservations(){
        String query = "select * from reservations ;";
        try(Connection con = dbconnect.getConnection(); Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt("id") + "|" + rs.getInt("room_id") + "|" + rs.getInt("guest_id") + "|" + rs.getDate("check_in") + "|" + rs.getDate("check_out"));
            }
        }
        catch (SQLException e){e.printStackTrace();}
    }
}

