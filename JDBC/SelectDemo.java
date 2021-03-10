package com.mph;

//check once in video
import java.sql.*;

public class SelectDemo {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement pstat = null;
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
            System.out.println("connected");
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            pstat = connection.prepareStatement("select * from jdbcdb.products where ID =4");//toggle a breakpoint and debug it
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString(2));
            }


            System.out.println("selected");


        }
        catch (
                SQLException throwables) {
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
