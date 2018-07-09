/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.model;

import edu.mou.rps.controllers.WBRPSDatabase;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kolis
 */
public class Staff implements Serializable {

    public Staff() {
    }
    private static boolean valid = false;
    private String username;
    private String jobRole;
    private String department;
    private int totalNumberOfHods;

    /**
     * @return the jobRole
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public String getJobRole() throws ClassNotFoundException, SQLException {
        String sql = "select Job_Role from staff where username = ?";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, getUsername());
        ResultSet rs
                = ps.executeQuery();
        while (rs.next()) {
            jobRole = rs.getString(1);
        }
        WBRPSDatabase.disconnect();
        return jobRole;

    }

    /**
     * @param jobRole the jobRole to set
     */
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    /**
     * @return the department
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public String getDepartment() throws ClassNotFoundException, SQLException {
        String sql = "select department_name from departments where department_id = (select department_id from staff where username = ?)";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            this.setDepartment(rs.getString(1));
        }
        WBRPSDatabase.disconnect();
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;

    }

    public boolean validate(String username, String password) throws ClassNotFoundException, SQLException {
        String sql = "select * from staff where username=? and password =? ";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {
            i++;
        }

        if (i == 1) {
            setValid(true);
        }
        WBRPSDatabase.disconnect();
        return isValid();
    }

    /**
     * @return the valid
     */
    public static boolean isValid() {
        return valid;
    }

    /**
     * @param aValid the valid to set
     */
    public static void setValid(boolean aValid) {
        valid = aValid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the totalNumberOfHods
     */
    public int getTotalNumberOfHods() {
        try {
            String sql = "select count(*) from staff where faculty_id"
                    + "= 1 and job_role = 'HOD'";
            Statement st = WBRPSDatabase.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
             totalNumberOfHods = rs.getInt(1);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalNumberOfHods;
    }

    /**
     * @param totalNumberOfHods the totalNumberOfHods to set
     */
    public void setTotalNumberOfHods(int totalNumberOfHods) {
        this.totalNumberOfHods = totalNumberOfHods;
    }

}
