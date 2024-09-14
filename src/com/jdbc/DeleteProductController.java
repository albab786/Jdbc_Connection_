package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProductController {

    public static void main(String[] args) {
        Connection connection=null;

        try {
            //step-1 load/register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step-2 create connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String pass = "root";

            connection= DriverManager.getConnection(url, user, pass);

            System.out.println(connection);

            //step-3 create Statement
            Statement statement=connection.createStatement();

            //step-4 execute Query
            String deleteStudentQuery = "delete from product where id=126";
            int a=statement.executeUpdate(deleteStudentQuery);
            if(a!=0){
                System.out.println("data deleted");
            }else {
                System.out.println("data not found");
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
