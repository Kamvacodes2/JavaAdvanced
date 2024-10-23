package com.example;

import java.sql.*;

public class DeleteExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/employee_db";
        String username = "postgres";
        String password = "Kristine";
        try(Connection con = DriverManager.getConnection(url, username, password)){
            Statement stmt = con.createStatement();
            String query = "DELETE FROM employess WHERE emp_id=12";
            if(stmt.executeUpdate(query)>0){
                System.out.println("Employee deleted successfully");
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
        }catch (SQLException e) {
            while (e!=null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Error Message: " + e.getMessage());
                Throwable t = e.getCause();
                while (t!=null) {
                    System.out.println("Cause: " + t.getCause());
                }
                e = e.getNextException();
            }
        }
    }
}
