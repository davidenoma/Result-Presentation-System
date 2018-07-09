/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.controllers;

import edu.mou.rps.model.Courses;
import edu.mou.rps.model.Student;
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
public class GetStudents extends HttpServlet {

    Student st = new Student();
    Courses course = new Courses();

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetStudents</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetStudents at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            st.setDepartment(request.getParameter("departments"));
            st.setProgram(request.getParameter("programs"));
            st.setLevel(Integer.parseInt(request.getParameter("level")));
            st.setRegistrationNumbers();
            st.setSemesterSelected(Integer.parseInt(request.getParameter("semester")));
            course.setSemester(Integer.parseInt(request.getParameter("semester")));
            course.setLevel(Integer.parseInt(request.getParameter("level")));
            course.setProgram(request.getParameter("programs"));
            course.setCourses();
            
            request.getSession().setAttribute("st", st);
            request.getSession().setAttribute("course", course);
            
            RequestDispatcher rd = request.getRequestDispatcher("getregistrationnumbers.jsp");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetStudents.class.getName()).log(Level.SEVERE, null, ex);
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
