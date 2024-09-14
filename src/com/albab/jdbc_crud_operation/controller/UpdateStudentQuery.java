package com.albab.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentQuery {
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
            String updateStudentQuery = "update student set name='sallu bahai' where id=125";
            int a=statement.executeUpdate(updateStudentQuery);
            if(a!=0){
                System.out.println("data updated");
            }else {
                System.out.println("data not found");
            }


        } catch (ClassNotFoundException | SQLException e) {
          }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
