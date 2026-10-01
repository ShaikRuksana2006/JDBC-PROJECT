package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryAppTask5 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "Ruksana@2006";

        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to database");

            // Task 5: Delete book with book_id 3
            String sql = "DELETE FROM books WHERE book_id = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, 3);

                int rows = ps.executeUpdate();

                if (rows == 0) {
                    System.out.println("No book found.");
                } else {
                    System.out.println("Book deleted.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}