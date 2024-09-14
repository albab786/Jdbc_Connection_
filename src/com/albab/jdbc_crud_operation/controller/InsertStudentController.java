package com.albab.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
    public static void main(String[] args) {


        Connection connection=null;

        try {
            //step-1 load/register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step-2 create connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String pass = "root";

            connection=DriverManager.getConnection(url, user, pass);

            System.out.println(connection);

            //step-3 create Statement
            Statement statement=connection.createStatement();

            //step-4 execute Query
            String insertStudentQuery = "insert into student (id,name,email,dob,phone) values(126,'john snow','jack@gmail.com','2024-09-01','7657657')" ;

            statement.execute(insertStudentQuery);

            System.out.println("Data stored");
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
