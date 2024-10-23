package example;

import java.sql.*;

public class UpdateExample {
    public static void main(String[] args) {
//        Create URL
        String url = "jdbc:postgresql://localhost:5432/employee_db";
        String username = "postgres";
        String password = "Kristine";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String query = "UPDATE employess SET surname='Fez' WHERE emp_id=12";
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("Inserted an employee successfully");
            }
            String query1 = "SELECT * FROM employess";
            ResultSet rs = stmt.executeQuery(query1);
            while (rs.next()) {
                int empID = rs.getInt("emp_id");
                String first = rs.getString("first_name");
                String last = rs.getString("surname");
                double salary = rs.getDouble("salary_id");
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first + " " + last + "\n"
                        + "Salary:        " + salary + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
