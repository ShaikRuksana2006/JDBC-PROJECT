package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Ruksana@2006";

        try {

            // Connect to database
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            // Create Statement
            Statement st = con.createStatement();

            // SQL query
            String sql = "SELECT * FROM students";

            // Execute query
            ResultSet rs = st.executeQuery(sql);

            // Read data
            while (rs.next()) {

                int id = rs.getInt("id");

                String name = rs.getString("name");

                int age = rs.getInt("age");

                // Print data
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("-------------------");
            }

            // Close resources
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}