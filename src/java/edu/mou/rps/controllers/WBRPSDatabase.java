/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.controllers;

import java.sql.*;

/**
 *
 * @author kolis
 */
public class WBRPSDatabase  {
    private static Connection con;

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/wbrps", "root", ""));
        return getCon();
    }

    public static void disconnect() throws SQLException, ClassNotFoundException {
        if (getCon() != null) {
            getCon().close();
        }

    }

    /**
     * @return the con
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection getCon() throws ClassNotFoundException, SQLException { 
        

        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

}
