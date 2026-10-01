package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LibraryAppTask2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "Ruksana@2006";

        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {

            // Task 1
            System.out.println("Connected to database");

            // Task 2: Display all books
            String sql = "SELECT * FROM books";

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {

                    System.out.println(
                            rs.getInt("book_id") + " | " +
                                    rs.getString("title") + " | " +
                                    rs.getString("author") + " | " +
                                    rs.getDouble("price")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}