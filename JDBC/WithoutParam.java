package com.mph;

import java.sql.*;

public class WithoutParam {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement cstat = null;
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
            System.out.println("connected");
            cstat = connection.prepareCall("{call getActors()}");

            ResultSet result = cstat.executeQuery();
            while(result.next()){
                System.out.println(result.getString(1)+ " "+ result.getString(2));
            }
        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
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



