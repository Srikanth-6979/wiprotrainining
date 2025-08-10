package com.wipro.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/student"; 
        String username = "root"; 
        String password = "Srikanth@6789"; 

        String insertSQL = "INSERT INTO employee (emp_name, department) VALUES (?, ?)";

        try {
            
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);

            PreparedStatement stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, "John Doe");         
            stmt.setString(2, "IT");               

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee inserted successfully.");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
