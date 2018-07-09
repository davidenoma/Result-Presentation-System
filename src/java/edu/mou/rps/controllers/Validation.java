/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mou.rps.controllers;

import edu.mou.rps.model.Courses;
import edu.mou.rps.model.Departments;
import edu.mou.rps.model.Programs;
import edu.mou.rps.model.Staff;
import edu.mou.rps.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kolis
 */
@WebServlet(name = "Validation", urlPatterns = {"/Validation"})
public class Validation extends HttpServlet {

    Staff staff = new Staff();
    Programs program = new Programs();
    Departments department_ = new Departments();
    Student student_ = new Student();
    Student student = new Student();
    Courses course = new Courses();
    public static String jobRolePlaceHolder;
    public static String departmentPlaceHolder;

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
            out.println("<title>Servlet Validation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validation at " + request.getContextPath() + "</h1>");
            if (request.getParameter("username").equals("") || request.getParameter("password").equals("")) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please input Username or Password and Try again.');");
                out.println("location='index.jsp';");
                out.println("</script>");

            } else if (request.getParameter("username").equals("admin") || request.getParameter("password").equals("admin")) {
                RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
                rd.forward(request, response);
            } else {
                try {
                    if (staff.validate(request.getParameter("username"), request.getParameter("password")) == true) {
                        staff.setUsername(request.getParameter("username"));

                        switch (staff.getJobRole()) {
                            case "Dean":
                                {
                                    jobRolePlaceHolder = staff.getJobRole();
                                    department_.setNumberOfDepartments();
                                    student_.setTotalNumberOfStudents();
                                    staff.setJobRole(jobRolePlaceHolder);
                                    request.getSession().setAttribute("staff", staff);
                                    request.getSession().setAttribute("department", department_);
                                    request.getSession().setAttribute("student", student_);
                                    RequestDispatcher rd = request.getRequestDispatcher("dean_dashboard.jsp");
                                    rd.forward(request, response);
                                    break;
                                }
                            case "HOD":
                                {
                                    jobRolePlaceHolder = staff.getJobRole();
                                    departmentPlaceHolder = staff.getDepartment();
                                    program.setDepartmentPrograms(staff.getDepartment());
                                    course.setNumberOfCoursesInDepartment(departmentPlaceHolder);
                                    student.setNumberOfStudentsInDepartment(departmentPlaceHolder);
                                    staff.setJobRole(jobRolePlaceHolder);
                                    department_.setDepartmentName(departmentPlaceHolder);
                                    request.getSession().setAttribute("department",department_);
                                    request.getSession().setAttribute("course", course);
                                    request.getSession().setAttribute("student", student);
                                    request.getSession().setAttribute("staff", staff);
                                    request.getSession().setAttribute("program", program);
                                    RequestDispatcher rd = request.getRequestDispatcher("hods_dashboard.jsp");
                                    rd.forward(request, response);
                                    break;
                                }
                            default:
                                break;
                        }

                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Your Username or Password is incorrect. Please input the correct values and try again.');");
                        out.println("location='index.jsp';");
                        out.println("</script>");
                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    out.print("<h3> " + ex.getMessage() + "</h3>");
                }

            }
            out.println("</body>");
            out.println("</html>");
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
