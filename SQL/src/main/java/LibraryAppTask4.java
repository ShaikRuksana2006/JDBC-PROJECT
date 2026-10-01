package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryAppTask4 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "Ruksana@2006";

        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to database");

            // Task 4: Update price of book_id 2
            String sql =
                    "UPDATE books SET price = ? WHERE book_id = ?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setDouble(1, 300.0);
                ps.setInt(2, 2);

                int rows = ps.executeUpdate();

                System.out.println(rows + " row updated");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}