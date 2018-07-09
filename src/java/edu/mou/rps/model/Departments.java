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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kolis
 */
public class Departments implements Serializable{

    public static String departmentSelected;
    private String departments[] = new String[10];
    private String programs[] = new String[10];
    private int levelSelected;
    private String departmentName;
    private int numberOfDepartments;
    public Departments(){}
    
    public String[] getDepartments() {
        try {
            String sql = "select department_name from departments";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {
                departments[i] = rs.getString(1);
                i++;
            }
            WBRPSDatabase.disconnect();

        } catch (ClassNotFoundException | SQLException ex) {
           out.println("<a>"+ex.getMessage()+"</a>");
        }
        return departments;
    }

    /**
     * @return the programs
     */
    public String[] getPrograms() {
        return programs;
    }

    /**
     * @param programs the programs to set
     */
    public void setPrograms(String programs) {
        
    }

    /**
     * @return the levelSelected
     */
    public int getLevelSelected() {
        return levelSelected;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the numberOfDepartments
     */
    public int getNumberOfDepartments() {
           try {
            String sql = "select count(*) from departments where faculty_id"
                    + "= 1";
            Statement st = WBRPSDatabase.connect().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
             this.numberOfDepartments = rs.getInt(1);
            }
WBRPSDatabase.disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
           return numberOfDepartments;
    }

    /**
     */
    public void setNumberOfDepartments() {
       
        
    }
}
