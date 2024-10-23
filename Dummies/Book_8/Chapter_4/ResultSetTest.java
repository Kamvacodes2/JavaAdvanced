package Chapter_4;

import java.sql.*;

public class ResultSetTest {

    public static void main(String[] args) {
        Connection con = getConnection();

        if (con != null) {
            try {
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("SELECT * FROM movie");

                // Uncomment as needed: Delete a row
//                rs.absolute(4);
//                rs.deleteRow();
//                System.out.println("Successfully Deleted Row 4");

                // Uncomment as needed: Update a row
//                rs.absolute(6);
//                rs.updateInt("year", 1975);
//                rs.updateRow();
//                System.out.println("Updated row 6 to year 1975");

                // Insert a row
                rs.moveToInsertRow();
                rs.updateString("title", "Monty Python and the Holy Grail");
                rs.updateInt("year", 1975);
                rs.updateDouble("price", 13.95);
                rs.insertRow();
                rs.moveToCurrentRow();
                System.out.println("Inserted a new row");

            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } finally {
                try {
                    if (con != null && !con.isClosed()) {
                        con.close();
                        System.out.println("Connection closed.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    private static Connection getConnection() {
        Connection con = null;
        try {
            // Removed Class.forName as it is not needed for PostgreSQL in modern JDBC
            String url = "jdbc:postgresql://localhost:5432/movies";  // PostgreSQL connection URL
            String user = "postgres";  // Replace with your PostgreSQL username
            String pw = "Rishen360#";       // Replace with your PostgreSQL password
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return con;
    }
}
