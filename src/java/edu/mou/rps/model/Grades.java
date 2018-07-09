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

/**
 *
 * @author kolis
 */
public class Grades implements Serializable {

    //private String courseTitles[];
    private int totalNumber[] = new int[15];
    private int numberOfEnrollments;
    private int totalNumberOfPass[] = new int[15];
    private int totalNumberOfFails[] = new int[15];
    private int totalNumberOfA[] = new int[15];
    private int totalNumberOfB[] = new int[15];
    private int totalNumberOfC[] = new int[15];
    private int totalNumberOfD[] = new int[15];
    private int totalNumberOfE[] = new int[15];
    private int totalNumberOfF[] = new int[15];

    public Grades() {

    }

    /**
     * @return the totalNumber
     */
    public int[] getTotalNumber() {
        return totalNumber;
    }

    /**
     * @param courseTitles
     * @param semester
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumber(String courseTitles[], int semester, String program) throws ClassNotFoundException, SQLException {
        totalNumber = new int[courseTitles.length];
        int i = 0;
        for (String x : courseTitles) {
            setNumberOfEnrollments(x, semester, program);
            totalNumber[i] = getNumberOfEnrollments();
            i++;
        }

    }

    /**
     * @return the numberOfEnrollments
     */
    public int getNumberOfEnrollments() {
        return numberOfEnrollments;
    }

    /**
     * @param courseTitle to find its number of enrolments from the results
     * table.
     * @param semester
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void setNumberOfEnrollments(String courseTitle, int semester, String program) throws SQLException, ClassNotFoundException {
        if (courseTitle != null) {
            if (semester == 1) {
                String sql = "select count(*) from results_semester_one where course_id in (select id from courses where name = ? and program_id =(select Program_id from Programs where progRam_name=?)) ";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setString(1, courseTitle);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.numberOfEnrollments = rs.getInt(1);
                }
                WBRPSDatabase.disconnect();
            } else {
                String sql = "select count(*) from results_semester_two where course_id in (select id from courses where name = ? and program_id = (select Program_id from Programs where progRam_name=?)) ";
                PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
                ps.setString(1, courseTitle);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.numberOfEnrollments = rs.getInt(1);
                }
                WBRPSDatabase.disconnect();
            }
        }
    }

    /**
     * @return the totalNumberOfPass
     */
    public int[] getTotalNumberOfPass() {
        return totalNumberOfPass;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void setTotalNumberOfPass(String courseTitles[], int semester, String program) throws SQLException, ClassNotFoundException {

        if (semester == 1) {
            String sql = "select count(*) from results_semester_one where course_id in (select id from courses where name = ? and program_id = (select Program_id from Programs where progRam_name=?)) and examsscore >= 40";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    this.totalNumberOfPass[i] = rs.getInt(1);

                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) from results_semester_two where course_id in (select id from courses where name = ? and program_id = (select Program_id from Programs where progRam_name=?)) and examsscore >= 40";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.numberOfEnrollments = rs.getInt(1);
                }
            }
            i++;
            WBRPSDatabase.disconnect();
        }
    }

    /**
     * @return the totalNumberOfFails
     */
    public int[] getTotalNumberOfFails() {
        return totalNumberOfFails;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfFails(String courseTitles[], int semester, String program) throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one where course_id in (select id from courses where name = ? and program_id=(select Program_id from Programs where progRam_name=?)) and examsscore < 40";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfFails[i] = rs.getInt(1);
                }
                i++;
            }

            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) from results_semester_two where course_id in (select id from courses where name = ? and program_id=(select Program_id from Programs where progRam_name=?)) and examsscore < 40";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfFails[i] = rs.getInt(1);
                }
                i++;
            }

            WBRPSDatabase.disconnect();
        }
    }

    /**
     * @return the totalNumberOfA
     */
    public int[] getTotalNumberOfA() {
        return totalNumberOfA;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfA(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id in (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'A'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfA[i] = rs.getInt(1);
                }
                i++;
            }

            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'A'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfA[i] = rs.getInt(1);
                }
                i++;
            }

            WBRPSDatabase.disconnect();
        }

    }

    /**
     * @return the totalNumberOfB
     */
    public int[] getTotalNumberOfB() {
        return totalNumberOfB;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfB(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id = (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'B'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfB[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'B'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfB[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        }
    }

    /**
     * @return the totalNumberOfC
     */
    public int[] getTotalNumberOfC() {
        return totalNumberOfC;
    }

    /**
     * @param courseTitles
     * @param program
     * @param semester
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfC(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id = (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'C'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfC[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'C'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfC[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        }
    }

    /**
     * @return the totalNumberOfD
     */
    public int[] getTotalNumberOfD() {
        return totalNumberOfD;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfD(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id = (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'D'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfD[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'D'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfD[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        }
    }

    /**
     * @return the totalNumberOfE
     */
    public int[] getTotalNumberOfE() {
        return totalNumberOfE;
    }

    /**
     * @param courseTitles
     * @param semester
     * @param program
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void setTotalNumberOfE(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
        if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id = (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'E'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfE[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'E'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfE[i] = rs.getInt(1);
                }
                i++;
            }

        }
    }
        /**
         * @return the totalNumberOfF
         */
    public int[] getTotalNumberOfF() {
        return totalNumberOfF;
    }

    /**
     * @param totalNumberOfF the totalNumberOfF to set
     */
    public void setTotalNumberOfF(String courseTitles[], int semester, String program)
            throws ClassNotFoundException, SQLException {
               if (semester == 1) {
            String sql = "select count(*) from results_semester_one "
                    + "where course_id = (select id "
                    + "from courses "
                    + "where name = ? "
                    + "and program_id="
                    + "(select Program_id from "
                    + "Programs where progRam_name=?)) and grade = 'F'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfF[i] = rs.getInt(1);
                }
                i++;
            }
            WBRPSDatabase.disconnect();
        } else {
            String sql = "select count(*) "
                    + "from results_semester_two"
                    + " where course_id = "
                    + "(select id"
                    + " from courses "
                    + "where name = ? and "
                    + "program_id="
                    + "(select Program_id"
                    + " from Programs"
                    + " where progRam_name=?)) "
                    + "and grade = 'F'";
            PreparedStatement ps = WBRPSDatabase.connect().prepareStatement(sql);
            int i = 0;
            for (String x : courseTitles) {
                ps.setString(1, x);
                ps.setString(2, program);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    this.totalNumberOfF[i] = rs.getInt(1);
                }
                i++;
            }

        }
    }
}
