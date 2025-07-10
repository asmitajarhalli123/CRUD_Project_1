package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {

    static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "asmita123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }
}//dbconnect
