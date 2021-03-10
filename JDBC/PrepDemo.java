package com.mph;

import java.beans.PropertyEditorSupport;
import java.sql.*;

public class PrepDemo {
    public static void main(String[] args) {

    Connection connection = null;
    PreparedStatement pstat = null;
        try {
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
        System.out.println("connected");

        connection.setAutoCommit(false);
        System.out.println(connection.getTransactionIsolation());

            pstat = connection.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?)");//toggle a breakpoint and debug it
            pstat.setInt(1,3);
            pstat.setString(2,"PEN DRIVE");//parameterIndex is the placeholder
            pstat.setInt(3,200);
            pstat.executeUpdate();
            System.out.println("inserted");

            pstat = connection.prepareStatement("select * from jdbcdb.products where ID =3");//toggle a breakpoint and debug it
            ResultSet rs = pstat.executeQuery();
            rs.next();
            System.out.println(rs.getString(2));
        System.out.println("selected");

        connection.commit();//instead of commit at each stmt , u can make autocommit to false and then commit it at the end with codition

    }
        catch (
    SQLException throwables) {
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
//commit or rollback to end a transaction
