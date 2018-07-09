/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.controllers;

import edu.mou.rps.model.Courses;
import edu.mou.rps.model.Departments;
import edu.mou.rps.model.Grades;
import edu.mou.rps.model.Programs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kolis
 */
public class GetHODResults extends HttpServlet {

    Courses course = new Courses();
    Grades grade = new Grades();
    Departments department = new Departments();
    Programs program = new Programs();

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
            /* TODO output your page here. You may use following sample code. */
            course.setCourseCodes(request.getParameter("program"), Integer.parseInt(request.getParameter("semester")), Integer.parseInt(request.getParameter("level")));
            course.setCourseTitles(request.getParameter("program"), Integer.parseInt(request.getParameter("semester")), Integer.parseInt(request.getParameter("level")));
            course.setCourseCodeCount(course.getCourseCodes());
            course.setLevel(Integer.parseInt(request.getParameter("level")));
            int semester = Integer.parseInt(request.getParameter("semester"));
           program.setProgramName(request.getParameter("program"));
            int i = 0;
            for (String x : course.getCourseTitles()) {
                if (x != null) {
                    grade.setNumberOfEnrollments(x, semester, request.getParameter("program"));
                    grade.getTotalNumber()[i] = grade.getNumberOfEnrollments();
                    System.out.println(grade.getTotalNumber()[i]);

                    i++;

                }
            }
            grade.setTotalNumberOfPass(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfFails(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfA(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfB(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfC(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfD(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfE(course.getCourseTitles(), semester, request.getParameter("program"));
            grade.setTotalNumberOfF(course.getCourseTitles(), semester, request.getParameter("program"));

            request.getSession().setAttribute("course", course);
            request.getSession().setAttribute("grade", grade);
            request.getSession().setAttribute("program", program);
            RequestDispatcher rd = request.getRequestDispatcher("hodsresulttable.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetHODResults.class.getName()).log(Level.SEVERE, null, ex);
        }
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
