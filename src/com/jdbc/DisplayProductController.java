package com.jdbc;

import java.math.BigInteger;
import java.sql.*;

public class DisplayProductController {
    public static void getDataByPrice(int data) {
        Connection connection = null;

        try {
            //step-1 load/register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step-2 create connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String pass = "root";

            connection = DriverManager.getConnection(url, user, pass);

            System.out.println(connection);

            //step-3 create Statement
            Statement statement = connection.createStatement();

            //step-4 execute Query
            String displayAllStudentQuery = "select * from product order by color";
            ResultSet set = statement.executeQuery(displayAllStudentQuery);


            while (set.next()) {
                System.out.println("===========================");
                int id = set.getInt("id");
                String name = set.getString("name");
                Long price = set.getLong("price");
                String color = set.getString("color");


                if (price > data) {
                    System.out.println("id is" + id);
                    System.out.println("name is" + name);
                    System.out.println("price  is" + price);
                    System.out.println("color is" + color);
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void getAllData() {
        Connection connection = null;

        try {
            //step-1 load/register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step-2 create connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String user = "root";
            String pass = "root";

            connection = DriverManager.getConnection(url, user, pass);

            System.out.println(connection);

            //step-3 create Statement
            Statement statement = connection.createStatement();

            //step-4 execute Query
            String displayAllStudentQuery = "select * from product order by color";
            ResultSet set = statement.executeQuery(displayAllStudentQuery);


            while (set.next()) {
                System.out.println("===========================");
                int id = set.getInt("id");
                String name = set.getString("name");
                Long price = set.getLong("price");
                String color = set.getString("color");
                System.out.println("id is" + id);
                System.out.println("name is" + name);
                System.out.println("price is " + price);
                System.out.println("color is" + color);


            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        getAllData();
//        getDataByPrice(3000);


    }
}
