package com.albab.jdbc_crud_operation.controller;

import java.sql.*;

public class DisplayStudentController {
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
           String displayAllStudentQuery="select * from student";
            ResultSet set= statement.executeQuery(displayAllStudentQuery);



            while (set.next()){
                System.out.println("===========================");
                int id=set.getInt("id");
                String name=set.getString("name");
                String email=set.getString("email");
                Long phoneNo= set.getLong("phone");
                Object dob=set.getObject("dob");

                System.out.println("id is"+id);
                System.out.println("name is"+name);
                System.out.println("phone no is"+phoneNo);
                System.out.println("email is"+email);
                System.out.println("dob is "+dob);
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
