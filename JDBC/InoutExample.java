package com.mph;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InoutExample {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement cstat = null;
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
            System.out.println("connected");
            cstat = connection.prepareCall("{call formatPhoneNumber(?)}");

            cstat.setString(1, "2222222");
            cstat.execute();

            String phone = cstat.getString(1);

            System.out.println(phone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (cstat != null && !cstat.isClosed()) {
                    cstat.close();
                    System.out.println("callablestatement closed");
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("connection closed");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }
    }
}

//what needs to be invoked, passed can be told in beforhand for stored procedures (offers security)
//pre compiled sql queries
//

