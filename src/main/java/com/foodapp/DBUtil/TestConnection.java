package com.foodapp.DBUtil;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully.");
            System.out.println("Driver loaded");
        } else {
            System.out.println("Connection Failed.");
        }
    }
}