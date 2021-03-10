package com.mph;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection=null;
        CallableStatement cstat =null;
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // add library in the lib folder
             connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdb", "priya", "priya@123");
             System.out.println("connected");

             cstat = connection.prepareCall("{call getName(?,?)}"); // 1 specifies first param , 2 is second

            cstat.setInt(1,1234); //in param can only be used to pass value into the procedure
            cstat.execute();

            String name = cstat.getString(2); //java.sql.SQLException: Parameter 1 is not registered as an output parameter
//out param to get value out of procedure
            System.out.println(name);






//            DatabaseMetaData dbmd = connection.getMetaData();
//
//            ResultSet rs = dbmd.getTables(null, "", null, new String[]{"TABLE"});
//            while (rs.next()) {
//                System.out.println(rs.getString(3));
//            }

            //PreparedStatement preparedStatement = connection.prepareStatement("select * from products");
//            PreparedStatement preparedStatement = connection.prepareStatement("select name as 'PRODUCT NAME' from products");
//            ResultSet result = preparedStatement.executeQuery();
//            ResultSetMetaData rsmd = result.getMetaData();
//            int numberOfColumns = rsmd.getColumnCount();
//            System.out.println(numberOfColumns);
//
//            for(int counter=1;counter<=numberOfColumns;counter++){
//                //System.out.println(rsmd.getColumnName(counter)+ " : "+ rsmd.getColumnTypeName(counter));
//                System.out.println(rsmd.getColumnLabel(counter)+ " : "+ rsmd.getColumnTypeName(counter));
//            }
         }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if(cstat!=null && !cstat.isClosed()){
                    cstat.close();
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
    //close the conn, callablestmt and resultset in finally
