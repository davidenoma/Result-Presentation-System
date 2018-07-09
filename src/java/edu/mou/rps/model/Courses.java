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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kolis
 */
public class Courses implements Serializable {

    private int level;
    private int semester;
    private String department;
    private String program;
    private int courseId;
    private String courses[] = new String[20];
    private String courseCodes[] = new String[15];
    private String courseTitles[] = new String[15];
    private int courseCodeCount;
    private int numberOfCoursesInDepartment;

    public Courses() {
    }

    public void setCourses() {
        try {
            String sql = "select name from courses where level_id = ? and SEmester =? and program_id = (select program_id from programs where Program_Name=?)";

            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setInt(1, level);
            ps.setInt(2, semester);
            ps.setString(3, getProgram());
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                courses[i] = rs.getString(1);
                i++;
            }
            WBRPSDatabase.disconnect();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the courses
     */
    public String[] getCourses() {
        return courses;
    }

    /**
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param coursename
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setCourseId(String coursename) throws ClassNotFoundException, SQLException {
        String sql = "select id from courses where Name =? ";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, coursename);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            courseId = rs.getInt(1);
        }
        WBRPSDatabase.disconnect();

    }

    /**
     * @return the courseCodes
     */
    public String[] getCourseCodes() {
        return this.courseCodes;
    }

    /**
     * @param programName
     * @param semester
     * @param level
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setCourseCodes(String programName, int semester, int level) throws ClassNotFoundException, SQLException {
        String sql = "select course_code from courses where program_id=(select program_id from programs where program_name =?)"
                + "and semester = ? and level_id=?";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, programName);
        ps.setInt(2, semester);
        ps.setInt(3, level);

        ResultSet rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {
            if (rs.getString(1) != null) {
                courseCodes[i] = rs.getString(1);
            }
            i++;
        }
        WBRPSDatabase.disconnect();
    }

    /**
     * @return the courseCodeCount
     */
    public int getCourseCodeCount() {
        return courseCodeCount;
    }

    /**
     * @param courseCodes
     */
    public void setCourseCodeCount(String[] courseCodes) {
        int y =  0;
        for(String x: courseCodes){
        if (!(x == null))
            y++;
        }
        courseCodeCount = y;
    }

    /**
     * @return the courseTitles
     */
    public String[] getCourseTitles() {
        return this.courseTitles;
    }

    /**
     * @param programName
     * @param semester
     * @param level
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setCourseTitles(String programName, int semester, int level) throws ClassNotFoundException, SQLException {
        String sql = "select name from courses where program_id=(select program_id from programs where program_name =?)"
                + "and semester = ? and level_id=?";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, programName);
        ps.setInt(2, semester);
        ps.setInt(3, level);

        ResultSet rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {
            if (rs.getString(1) != null) {
                courseTitles[i] = rs.getString(1);
            }
            i++;
        }
        WBRPSDatabase.disconnect();
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * @return the numberOfCoursesInDepartment
     */
    public int getNumberOfCoursesInDepartment() {
        return numberOfCoursesInDepartment;
    }

    /**
     * @param department
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void setNumberOfCoursesInDepartment(String department) throws SQLException, ClassNotFoundException {
        String sql = "select count(*) from courses where program_id in (select program_id from programs where department_id =(select department_id "
                + "from departments where department_name = ?))";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, department);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        numberOfCoursesInDepartment = rs.getInt(1);
        }
        WBRPSDatabase.disconnect();
       

    }

}
