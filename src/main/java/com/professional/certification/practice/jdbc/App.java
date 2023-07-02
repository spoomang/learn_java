package com.professional.certification.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {

            try {
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_dummy", "api", "password");
                Statement statement = con.createStatement();


                ResultSet rs1 = statement.executeQuery("select * from event");
                ResultSet rs2 = statement.executeQuery("select * from event");

                rs1.next();
                System.out.println(rs1.getString(2));


                rs2.next();
                System.out.println(rs2.getString(2));

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
