package Chapter_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUpdate {

    public static void main(String[] args) {
        loanMovie(3, "Drinkwater", "Mark");
    }

    private static void loanMovie(int id, String lastName, String firstName) {
        Connection con = getConnection();
        if (con != null) {
            try {
                // Use PreparedStatement to avoid SQL injection and ensure proper syntax
                String insert = "INSERT INTO FRIEND (lastname, firstname, movieid) VALUES (?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(insert);

                // Set values for the placeholders (?)
                pstmt.setString(1, lastName);
                pstmt.setString(2, firstName);
                pstmt.setInt(3, id);

                int result = pstmt.executeUpdate();

                if (result == 1) {
                    System.out.println("Loan recorded");
                } else {
                    System.out.println("Loan not recorded.");
                }
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    private static Connection getConnection() {
        Connection con = null;
        try {
            // PostgreSQL connection URL and credentials
            String url = "jdbc:postgresql://localhost:5432/movies";
            String user = "postgres";
            String pw = "Rishen360#";
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return con;
    }
}
