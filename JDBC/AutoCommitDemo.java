package com.mph;

import java.sql.*;

public class AutoCommitDemo {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement pstat = null;
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
            System.out.println("connected");

            connection.setAutoCommit(false);
            pstat = connection.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?)");//toggle a breakpoint and debug it
            pstat.setInt(1,2);
            pstat.setString(2,"MOUSE");//parameterIndex is the placeholder
            pstat.setInt(3,200);
            pstat.executeUpdate();
            System.out.println("inserted");

            connection.commit();//instead of commit at each stmt , u can make autocommit to false and then commit it at the end with codition

        }
        catch (SQLException throwables) {
            try {
                if(connection!=null && !connection.isClosed())
                connection.rollback(); // we do a rollback if exception occurs
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        finally {
            try {
                if(pstat!=null && !pstat.isClosed()){
                    pstat.close();
                    System.out.println("callablestatement closed");
                }
                if(connection!=null && !connection.isClosed())
                    connection.close();
                System.out.println("connection closed");

            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }

    }
}

// we have made changes to table but its not commited and read it is dirty read
//when we set auto commit to be false , after inserted step , we cant view the updated value in the workbench
//when the connection is closed gracefully , though the autocommit is set to false, u vl get the record in workbench
//when connection is closed abnormally , the insert vl be rolled back