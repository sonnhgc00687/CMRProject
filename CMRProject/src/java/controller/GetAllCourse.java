/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Course;
import model.manager.CourseManager;

/**
 *
 * @author Son
 */
@WebServlet(name = "GetAllCourse", urlPatterns = {"/GetAllCourse"})
public class GetAllCourse extends HttpServlet {

    private List<Course> courseList = new ArrayList<>();

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
            out.println("<title>Servlet GetAllCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetAllCourse at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userSession");
        int userRole = (int) session.getAttribute("userRole");
        CourseManager cm = new CourseManager();
        switch (userRole) {
            case 0:
                courseList = cm.getAllCourse();
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
            case 1:
                courseList = cm.getAllCourseByCourseLeader(userName);
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
            case 2:
                courseList = cm.getAllCourseByCourseMod(userName);
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
            case 3:
                courseList = cm.getAllCourse();
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
            case 4:
                courseList = cm.getAllCourse();
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("course.jsp").forward(request, response);
                break;
        }
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
