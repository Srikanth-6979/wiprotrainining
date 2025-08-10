package com.wipro.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentDatialsModification {
	
	static String url = "jdbc:mysql://localhost:3306/wiprojdbc2";
    static String userId = "root";
    static String passWord = "Srikanth@6789";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--Menu----");
            System.out.println("1. Print");
            System.out.println("2. Add Data");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    printData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    searchByRollNumber();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void printData() {
        try (Connection conn = DriverManager.getConnection(url, userId, passWord)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println("ID=" + rs.getInt("id") + " Name=" + rs.getString("student_name")
                        + " Roll Number=" + rs.getString("roll_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertData() {
        try (Connection conn = DriverManager.getConnection(url, userId, passWord)) {
            String sql = "INSERT INTO student (student_name, roll_number) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = sc.next();
            System.out.print("Enter roll number: ");
            String roll = sc.next();
            ps.setString(1, name);
            ps.setString(2, roll);
            ps.executeUpdate();
            System.out.println("Student added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void searchByRollNumber() {
        try (Connection conn = DriverManager.getConnection(url, userId, passWord)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter roll number to search: ");
            String roll = sc.next();
            String sql = "SELECT * FROM student WHERE roll_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roll);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID=" + rs.getInt("id") + " Name=" + rs.getString("student_name"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateStudent() {
        try (Connection conn = DriverManager.getConnection(url, userId, passWord)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student ID to update: ");
            int id = sc.nextInt();
            System.out.print("Enter new name: ");
            String name = sc.next();
            System.out.print("Enter new roll number: ");
            String roll = sc.next();
            String sql = "UPDATE student SET student_name = ?, roll_number = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, roll);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteStudent() {
        try (Connection conn = DriverManager.getConnection(url, userId, passWord)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
