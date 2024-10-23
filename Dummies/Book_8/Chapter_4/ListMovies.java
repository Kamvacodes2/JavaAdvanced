package Chapter_4;

import java.sql.*;
import java.text.NumberFormat;

public class ListMovies {
    private static Connection con;

    public static void main(String[] args) {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        ResultSet movies = getMovies();

        if (movies != null) {
            try {
                while (movies.next()) {
                    Movie m = getMovie(movies);
                    String msg = m.year + ": " + m.title + " (" + cf.format(m.price) + ")";
                    System.out.println(msg);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (con != null && !con.isClosed()) {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
    }

    private static ResultSet getMovies() {
        con = getConnection();
        try {
            Statement s = con.createStatement();
            String select = "SELECT * FROM movie ORDER BY year";
            return s.executeQuery(select);
        } catch (SQLException e) {
            System.out.println("Error retrieving movies: " + e.getMessage());
        }
        return null;
    }

    private static Connection getConnection() {
        try {
            // Removed the Class.forName as it's unnecessary for modern JDBC
            String url = "jdbc:postgresql://localhost:5432/movies";
            String user = "postgres";  // Adjust the PostgreSQL credentials
            String pw = "Rishen360#";       // Adjust the PostgreSQL credentials
            return DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private static Movie getMovie(ResultSet movies) {
        try {
            String title = movies.getString("title");  // Column names should match your table schema
            int year = movies.getInt("year");
            double price = movies.getDouble("price");
            return new Movie(title, year, price);
        } catch (SQLException e) {
            System.out.println("Error retrieving movie: " + e.getMessage());
        }
        return null;
    }

    private static class Movie {
        public String title;
        public int year;
        public double price;

        public Movie(String title, int year, double price) {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }
}
