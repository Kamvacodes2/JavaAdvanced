package Chapter_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
        Connection con = getconnection();
    }

    private static Connection getconnection()
    {
        Connection con = null;
        try
        {
            // Removed Class.forName as it's not required for modern JDBC
            String url = "jdbc:postgresql://localhost:5432/movies";
            String user = "postgres";
            String pw = "Rishen360#";
            con = DriverManager.getConnection(url, user, pw);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("SUCCESSFUL CONNECTION!");
        return con;
    }
}
