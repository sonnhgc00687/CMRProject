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
import model.entity.Faculty;
import model.entity.User;
import model.manager.CourseManager;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SearchCourse", urlPatterns = {"/SearchCourse"})
public class SearchCourse extends HttpServlet {

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
            out.println("<title>Servlet SearchCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchCourse at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userSession");
        int userRole = (int) session.getAttribute("userRole");
        CourseManager cm = new CourseManager();
        String findKey = request.getParameter("searchCourse");
        switch (userRole) {
            case 0:
                courseList = cm.searchCourseByTitle(findKey);
                break;
            case 1:
                courseList = cm.searchCourseByTitleByLeader(userName, findKey);
                break;
            case 2:
                courseList = cm.searchCourseByTitleByMod(userName, findKey);
                break;
            case 3:
                courseList = cm.searchCourseByTitleByPVC(findKey, findKey);
                break;

            case 4:
                courseList = cm.searchCourseByTitleByDLT(findKey, findKey);
                break;
            default:
                break;
        }
        if (!courseList.isEmpty()) {
            request.setAttribute("courseList", courseList);
            request.getRequestDispatcher("course.jsp").forward(request, response);
        } else {
            String errorMessage = "No record found";
            List<User> allUser = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();
            List<Faculty> facultyList = new ArrayList<>();

            UserManager userManager = new UserManager();
            allUser = userManager.getAllUsers();
            FacultyManager facultyManager = new FacultyManager();
            facultyList = facultyManager.getAllFaculty();

            for (User user : allUser) {
                if (user.getRole() == 1) {
                    leader.add(user);
                } else if (user.getRole() == 2) {
                    moderator.add(user);
                }
            }
            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("facultyList", facultyList);
            request.setAttribute("courseList", courseList);
            request.setAttribute("errorCode", 1);
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("course.jsp").forward(request, response);
        }
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
