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
public class Results implements Serializable {

    private int semester;
    private int mark;
    private String regNumber;
    private int studentId;
    private int course;
    private String courses[] = new String[20];
    private int marks[] = new int[20];
    private int course_id;
    private int resultCount;
    private int totalNumberOfResults;
    private int totalResultsSubmitted;

    public Results() {

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
     * @return the marks
     */
    public int getMark() {

        return mark;
    }

    /**
     * @param studentId
     * @param courseId
     * @param examScore
     * @param sem
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setMark(int studentId, int courseId, int examScore, int sem) throws ClassNotFoundException, SQLException {
        if (sem == 1) {
            String sql = "insert into results_semester_one (Student_id, Course_id, ExamsScore )values(?,?,?)";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, examScore);
            ps.executeUpdate();
            WBRPSDatabase.disconnect();
        } else {
            String sql = "insert into results_semester_two (Student_id, Course_id, ExamsScore )values(?,?,?)";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setInt(3, examScore);
            ps.executeUpdate();
            WBRPSDatabase.disconnect();

        }

    }

    public void updateMark(int studentId, int courseId, int examScore, int sem) throws ClassNotFoundException, SQLException {
        if (sem == 1) {
            String sql = "update results_semester_one set ExamsScore = ? where Student_id=? and Course_id = ?";
            PreparedStatement ps = WBRPSDatabase.connect()
                    .prepareStatement(sql);
            ps.setInt(1, examScore);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            ps.executeUpdate();

            WBRPSDatabase.disconnect();
        } else {
            String sql = "update results_semester_two set ExamsScore = ? where Student_id=? and Course_id = ?";
            PreparedStatement ps = WBRPSDatabase.connect()
                    .prepareStatement(sql);
            ps.setInt(1, examScore);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            ps.executeUpdate();

            WBRPSDatabase.disconnect();
        }

    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param regNumber To Set the Student Id for a Particular Student's Results
     * {@link edu.mou.rps.model.Student#registrationNumber}
     */
    public void setStudentId(String regNumber) {
        try {
            String sql = "select student_id from student where Reg_Number =?";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            ps.setString(1, regNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                studentId = rs.getInt(1);
            }
            WBRPSDatabase.disconnect();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the course
     */
    public int getCourse() {
        return course;
    }

    /**
     * @param course_id
     */
    public void setCourse(int course_id) {
        this.course = course_id;
    }

    /**
     * @return the course_id
     */
    public int getCourse_id() {
        return course_id;
    }

    /**
     * @param courseName
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setCourse_id(String courseName) throws ClassNotFoundException, SQLException {
        String sql = "select id from courses where name = ?";
        PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
        ps.setString(1, courseName);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                this.course_id = rs.getInt(1);
            }
        }
        WBRPSDatabase.disconnect();
    }

    /**
     * @return the courses
     */
    public String[] getCourses() {

        return courses;

    }

    /**
     */
    public void setCourses() {
        if (semester == 1) {
            try {

                String sql = "select name from courses where id in(select course_id from results_semester_one where student_id =?)";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setInt(1, studentId);
                ResultSet rs = ps.executeQuery();
                int j = 0;
                while (rs.next()) {
                    if (rs.getString(1) != null) {
                        courses[j] = rs.getString(1);

                    }
                    j++;

                }

                WBRPSDatabase.disconnect();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {

                String sql = "select name from courses where id in(select course_id from results_semester_two where student_id =?)";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setInt(1, studentId);
                ResultSet rs = ps.executeQuery();
                int j = 0;
                while (rs.next()) {
                    if (rs.getString(1) != null) {
                        courses[j] = rs.getString(1);

                    }
                    j++;

                }

                WBRPSDatabase.disconnect();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * @return the marks
     */
    public int[] getMarks() {
        return marks;
    }

    public void setMarks() {
        if (semester == 1) {
            try {
                String sql = "select examsScore from results_semester_one where student_id=?";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setInt(1, studentId);
                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    if (rs.getInt(1) != 0) {
                        marks[i] = rs.getInt(1);
                    }
                    i++;
                }
                WBRPSDatabase.disconnect();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String sql = "select examsScore from results_semester_two where student_id=?";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setInt(1, studentId);
                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    if (rs.getInt(1) != 0) {
                        marks[i] = rs.getInt(1);
                    }
                    i++;
                }
                WBRPSDatabase.disconnect();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * @return the regNumber
     */
    public String getRegNumber() {
        return regNumber;
    }

    /**
     * @param regNumber the regNumber to set
     */
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;

    }

    /**
     * @return the resultCount
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * This sets the result count by using the length of the marks array
     *
     * @see edu.mou.rps.model.Results method
     */
    public void setResultCount() {

        resultCount = this.marks.length;
    }

    /**
     * @return the totalNumberOfResults
     */
    public int getTotalNumberOfResults() {
        return totalNumberOfResults;
    }

    /**
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void setTotalNumberOfResults()
            throws SQLException, ClassNotFoundException {
        String sql = "select count( distinct student_id) from results_semester_one";
        Statement st = WBRPSDatabase.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            totalNumberOfResults = rs.getInt(1);

        }
        rs.close();
        st.close();
        String sql_ = "select count( distinct student_id) from results_semester_two";
        rs = st.executeQuery(sql_);
        while (rs.next()) {
            totalNumberOfResults += rs.getInt(1);

        }
        WBRPSDatabase.disconnect();
    }

    /**
     * @return the totalResultsSubmitted
     */
    public int getTotalResultsSubmitted() {
        int semesterOne = 0;
        int semesterTwo = 0;
        try {

            String sql1 = "select count(*) from results_semester_one";
            String sql2 = "select count(*) from results_semester_two";
            Statement st = WBRPSDatabase.connect().createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while (rs.next()) {
                semesterOne = rs.getInt(1);
            }
        

            st = WBRPSDatabase.connect().createStatement();
            ResultSet rs2 = st.executeQuery(sql2);
            while (rs.next()) {
                semesterTwo = rs2.getInt(1);
            }
            WBRPSDatabase.disconnect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalResultsSubmitted = semesterOne + semesterTwo;
        return totalResultsSubmitted;
    }

    /**
     * @param totalResultsSubmitted the totalResultsSubmitted to set
     */
    public void setTotalResultsSubmitted(int totalResultsSubmitted) {
        this.totalResultsSubmitted = totalResultsSubmitted;
    }

}
