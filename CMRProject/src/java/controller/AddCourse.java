/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Course;
import model.entity.User;
import model.manager.CourseManager;
import model.manager.UserManager;

/**
 *
 * @author Phuc
 */
@WebServlet(name = "AddCourse", urlPatterns = {"/AddCourse"})
public class AddCourse extends HttpServlet {

    private Course course;
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
        try {
            HttpSession session = request.getSession();

            String courseCode = request.getParameter("courseCode");
            String courseFaculty = request.getParameter("courseFaculty");
            String courseTitle = request.getParameter("courseTitle");
//            String courseLeader = request.getParameter("courserLeader");
//            String courseMod = request.getParameter("courseMod");
            String description = request.getParameter("description");
            String startDate = request.getParameter("startDate");
            Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            java.sql.Timestamp startDate2 = new Timestamp(startDate1.getTime());
            java.sql.Date startDateSQL = new java.sql.Date(startDate1.getTime());

            String endDate = request.getParameter("endDate");
            Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            java.sql.Timestamp endDate2 = new Timestamp(endDate1.getTime());
            java.sql.Date endDateSQL = new java.sql.Date(endDate1.getTime());

//            CourseManager courseManager = new CourseManager();
//            courseManager.AddCourse(courseCode, courseFaculty, courseTitle, "", "", startDate2, endDate2, description);
            List<User> allUser = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();
            UserManager userManager = new UserManager();
            allUser = userManager.getAllUsers();
            for (User user : allUser) {
                if (user.getRole() == 1) {
                    leader.add(user);
                } else if (user.getRole() == 2) {
                    moderator.add(user);
                }
            }

            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            course = new Course(courseCode, courseFaculty, courseTitle, "", "", startDateSQL, endDateSQL, description, 1);

            request.setAttribute("course", course);
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
            request.getRequestDispatcher("assignCourse.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
