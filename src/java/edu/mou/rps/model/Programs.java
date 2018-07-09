/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.model;

import edu.mou.rps.controllers.WBRPSDatabase;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author kolis
 */
public class Programs implements Serializable {

    private static String programs[] = new String[10];
    private String allPrograms[] = new String[10];
    public static String programSelected;
    private String programName;
    private String departmentPrograms[] = new String[5];

    public Programs() {
    }

    /**
     * @param department
     * @return Programs offered by a department
     */
    public static String[] getPrograms(String department) {
        try {
            String sql = "select Program_Name from programs where department_id = (select department_id from departments where department_Name = ?)";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                programs[i] = rs.getString(1);

                i++;
            }
            WBRPSDatabase.disconnect();

        } catch (SQLException | ClassNotFoundException ex) {
            out.println(ex.getMessage());
        }
        return programs;
    }

    public String[] getAllPrograms() {
        try {
            String sql = "select Program_Name from programs";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                programs[i] = rs.getString(1);
//                allPrograms[i] = rs.getString(1);
                i++;
            }
            WBRPSDatabase.disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            out.println(ex.getMessage());
        }
        return programs;
    }

    /**
     * @return the departmentPrograms
     */
    public String[] getDepartmentPrograms() {
        return departmentPrograms;
    }

    /**
     * @param department
     * @throws java.lang.ClassNotFoundException
     */
    public void setDepartmentPrograms(String department) throws SQLException, ClassNotFoundException {
        String sql = "select Program_Name from programs where department_id = (select department_id from departments where department_Name = ?)";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, department);
        ResultSet rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {
            departmentPrograms[i] = rs.getString(1);

            i++;
        }
        WBRPSDatabase.disconnect();

    }

    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param aProgramName the programName to set
     */
    public void setProgramName(String aProgramName) {
        programName = aProgramName;
    }
}
