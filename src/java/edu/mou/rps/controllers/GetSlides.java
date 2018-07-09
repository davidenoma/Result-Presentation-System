/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.mou.rps.Utilities.Presentation;
import edu.mou.rps.model.Courses;
import edu.mou.rps.model.Departments;
import edu.mou.rps.model.Grades;
import edu.mou.rps.model.Programs;
import edu.mou.rps.model.Staff;
import java.awt.geom.Rectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTableRow;

/**
 *
 * @author kolis
 */
public class GetSlides extends HttpServlet {

    Courses course = new Courses();
    Grades grade = new Grades();
    Departments department = new Departments();
    Programs program = new Programs();
    Staff staff;
    public static String fileLocation;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //This block gets the value of all the parameters from the view.
            course.setCourseCodes(request.getParameter("program"), Integer.parseInt(request.getParameter("semester")), Integer.parseInt(request.getParameter("level")));
            course.setCourseTitles(request.getParameter("program"), Integer.parseInt(request.getParameter("semester")), Integer.parseInt(request.getParameter("level")));
            course.setCourseCodeCount(course.getCourseCodes());

            course.setLevel(Integer.parseInt(request.getParameter("level")));
            int level = Integer.parseInt(request.getParameter("level"));
            int semester = Integer.parseInt(request.getParameter("semester"));
            program.setProgramName(request.getParameter("program"));
            department.setDepartmentName(request.getParameter("department"));
            int i = 0;
            for (String x : course.getCourseTitles()) {
                if (x != null) {

                    grade.setNumberOfEnrollments(x, semester, request.getParameter("program"));
                    grade.getTotalNumber()[i] = grade.getNumberOfEnrollments();
                    i++;

                }
            }
            // grade.setTotalNumberOfPass(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfFails(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfA(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfB(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfC(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfD(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfE(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfF(course.getCourseTitles(), semester, request.getParameter("program"));
            Presentation ps = new Presentation();
            //String jobRole = 
            staff = (Staff) request.getSession().getAttribute("staff");
            String jobRole = staff.getJobRole();
            ps.createTitlePage(department.getDepartmentName(), program.getProgramName(), level, semester, jobRole);

            ps.addRowsToTable(ps.getTable());
            int j = 0;
            while (j < course.getCourseCodeCount()) {
                switch (j) {
                    case 4: {
                        XSLFSlide slide = ps.getPptx().createSlide();
                        ps.setTable(slide.createTable());
                        ps.getTable().setAnchor(new Rectangle2D.Double(0, 0, 50, 20));
                        ps.addRowsToTable(ps.getTable());
                        System.out.println(ps.getTable().getNumberOfColumns());
                        ps.getTable().setColumnWidth(0, 100.0);
                        break;
                    }
                    case 7: {
                        XSLFSlide slide = ps.getPptx().createSlide();
                        ps.setTable(slide.createTable());
                        ps.getTable().setAnchor(new Rectangle2D.Double(0, 0, 50, 20));
                        ps.addRowsToTable(ps.getTable());
                        break;
                    }
                    case 10: {
                        XSLFSlide slide = ps.getPptx().createSlide();
                        ps.setTable(slide.createTable());
                        ps.getTable().setAnchor(new Rectangle2D.Double(0, 70, 70, 20));
                        ps.addRowsToTable(ps.getTable());
                        break;
                    }
                    case 12: {
                        XSLFSlide slide = ps.getPptx().createSlide();
                        ps.setTable(slide.createTable());
                        ps.getTable().setAnchor(new Rectangle2D.Double(0, 70, 70, 20));
                        ps.addRowsToTable(ps.getTable());
                        break;
                    }
                    default:
                        break;
                }
                //ps.getTable().setRowHeight(j, 22.0);

                XSLFTableRow row = ps.getTable().addRow();

                ps.getTable().setRowHeight(0, 2.0);
                ps.getTable().setColumnWidth(0, 40.0);
                ps.getTable().setColumnWidth(5, 40.0);
                ps.getTable().setColumnWidth(6, 40.0);
                ps.getTable().setColumnWidth(7, 40.0);
                ps.getTable().setColumnWidth(8, 40.0);
                ps.getTable().setColumnWidth(9, 40.0);
                ps.getTable().setColumnWidth(10, 40.0);
//                 ps.getTable().setRowHeight(j,22.0);

                row.addCell().setText(Integer.toString(j + 1));
                row.addCell().setText(course.getCourseCodes()[j]);
                // row.addCell().setText(course.getCourseTitles()[j]);
                row.addCell().setText(Integer.toString(grade.getTotalNumber()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfPass()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfFails()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfA()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfB()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfC()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfD()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfE()[j])).setFontSize(22.0);
                row.addCell().setText(Integer.toString(grade.getTotalNumberOfF()[j])).setFontSize(22.0);

                j++;

            }
            ps.writeToFile();
            fileLocation = ps.getFileLocation();
            request.getSession().setAttribute("ps", ps);
            request.getSession().setAttribute("program", program);
            request.getSession().setAttribute("department",department);
            request.getSession().setAttribute("staff",staff);
             RequestDispatcher rd = request.getRequestDispatcher("successpage.jsp");

            rd.forward(request, response);
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(GetSlides.class.getName()).log(Level.SEVERE, null, ex);
            PrintWriter out = response.getWriter();
            out.println("<h3 > An error Occured, please contact the admin: " + ex.getMessage() + "</h3>");
        }

//        for (int i = 0; i < course.getCourseCodeCount(); i++) {
//            ps.addRowContent(course, grade, i);
//        }
//        FileExplorer fx = new FileExplorer();
//        fx.jFileChooser1.updateUI();
//        fx.jFileChooser1.setSelectedFile(new File("presentation"));
//
//        fx.setVisible(true);
//        String fileName = fx.getFolderSelected()+"presentation";
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
