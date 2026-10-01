import java.sql.Connection;
import java.sql.DriverManager;

public class LibraryApp {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/library_db";
        String username = "root";
        String password = "Ruksana@2006";

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}