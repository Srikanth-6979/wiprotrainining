package com.wipro.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;

public class App 
{
	static String url = "jdbc:mysql://localhost:3306/wiprojdbc";
    static String userId = "root";
    static String passWord = "Srikanth@6789";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("--Menu----");
            System.out.println("--1. Print ---");
            System.out.println("--2. Add Data ---");
            System.out.println("--3. Exit ---");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    printData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        } while (true);
    }

    static void printData() {
        try {
            Connection conn = DriverManager.getConnection(url, userId, passWord);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id=" + rs.getInt(1) + " name=" + rs.getString(2) + " roll number=" + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertData() {
        try {
            Connection conn = DriverManager.getConnection(url, userId, passWord);
            String sql = "INSERT INTO student (student_name, roll_number) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter name:");
            String studentName = sc.next();
            System.out.println("Please enter roll number:");
            String rollNumber = sc.next();
            ps.setString(1, studentName);
            ps.setString(2, rollNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
	 
