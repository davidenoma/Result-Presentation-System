/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.model;

import java.sql.CallableStatement;
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
public class Student implements Serializable {

    private int student_id;
    private static int level;
    private static String department;
    private int department_id;
    private String program;
    private boolean resultsExist;
    private int totalNumberOfStudents;
    private int semesterSelected;
    private String registrationNumber;
    private String[] registrationNumbers;
    private String[] coursesOffered;
    private int numberOfStudentsInDepartment;

    public Student() {
        registrationNumbers = new String[50];
        coursesOffered = new String[20];
    }

    public String[] getRegistrationNumbers() throws ClassNotFoundException, SQLException {

        return this.registrationNumbers;
    }

    public void setRegistrationNumbers() throws ClassNotFoundException, SQLException {
        String sql = "select Reg_Number from student where department_id = (select department_id from departments where department_Name = ? )"
                + "and program_id =(select program_id from programs where Program_Name = ?)"
                + "and level_id = ?;";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, getDepartment());
        ps.setString(2, getProgram());
        ps.setInt(3, getLevel());
        ResultSet rs = ps.executeQuery();
        int i = 0;
        while (rs.next()) {
            registrationNumbers[i] = rs.getString(1);
            i++;
        }
        WBRPSDatabase.disconnect();

    }
    //public  

    /**
     * @return the student_id
     */
    public int getStudent_id() {
        return student_id;
    }

    /**
     * @param regNumber The registration number of the student to set his
     * student-id
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setStudent_id(String regNumber) throws ClassNotFoundException, SQLException {
        String sql = "select student_id from student where reg_number=?";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, regNumber);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            student_id = rs.getInt(1);
        }
        WBRPSDatabase.disconnect();

    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param aLevel the level to set
     */
    public void setLevel(int aLevel) {
        level = aLevel;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param aDepartment the department to set
     */
    public void setDepartment(String aDepartment) {
        department = aDepartment;
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param aProgram the program to set
     */
    public void setProgram(String aProgram) {
        program = aProgram;
    }

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param aRegistrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String aRegistrationNumber) {
        registrationNumber = aRegistrationNumber;
    }

    /**
     * @return the department_id
     */
    public int getDepartment_id() {
        return department_id;
    }

    /**
     * @param aDepartment_id the department_id to set
     */
    public void setDepartment_id(int aDepartment_id) {
        department_id = aDepartment_id;
    }

    /**
     * @return the coursesOffered
     */
    public String[] getCoursesOffered() {
        return coursesOffered;
    }

    /**
     * @param courses set the courses offered by a Student
     */
    public void setCoursesOffered(String[] courses) {

        coursesOffered = courses;
    }

    /**
     * @param regNo
     * @return the resultsExist
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public boolean isResultsExist(String regNo) throws ClassNotFoundException, SQLException {
        if (semesterSelected == 1) {
            String sql = "select * from results_semester_one where student_id = (select student_id from student where reg_number= ?)";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                resultsExist = false;

            } else {
                resultsExist = true;
            }

        } else {
            String sql = "select * from results_semester_two where student_id = (select student_id from student where reg_number= ?)";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                resultsExist = false;

            } else {
                resultsExist = true;
            }

        }
        WBRPSDatabase.disconnect();
        return resultsExist;
    }

    /**
     * To Check if a student's results already exists or not
     *
     */
    public void setResultsExist() {

    }

    /**
     * @return the semesterSelected
     */
    public int getSemesterSelected() {
        return semesterSelected;
    }

    /**
     * @param semester
     */
    public void setSemesterSelected(int semester) {

        semesterSelected = semester;

    }

    /**
     * @return the totalNumberOfStudents
     */
    public int getTotalNumberOfStudents() {
        try {
            String sql = "select count(Student_id) from student";
            ResultSet rs = WBRPSDatabase.connect().createStatement().executeQuery(sql);
            while (rs.next()) {
                this.totalNumberOfStudents = rs.getInt(1);
                
            }
            WBRPSDatabase.disconnect();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } return totalNumberOfStudents;
    }

    /**
     
     */
    public void setTotalNumberOfStudents(){
        
    }

    /**
     * @return the numberOfStudentsInDepartment
     */
    public int getNumberOfStudentsInDepartment() {
        return numberOfStudentsInDepartment;
    }

    /**
     * @param department The department to Set the Number of Students.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setNumberOfStudentsInDepartment(String department) throws ClassNotFoundException, SQLException {
        String sql = "select count(student_id) from student where department_id=(select department_id from departments where department_Name = ?)";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, department);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            numberOfStudentsInDepartment = rs.getInt(1);
        }
        WBRPSDatabase.disconnect();

    }
}
