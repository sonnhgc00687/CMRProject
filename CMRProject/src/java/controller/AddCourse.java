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
import model.entity.Faculty;
import model.entity.User;
import model.manager.CourseManager;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author Phuc
 */
@WebServlet(name = "AddCourse", urlPatterns = {"/AddCourse"})
public class AddCourse extends HttpServlet {

    private Course course;
    private List<Course> courseList = new ArrayList<>();
    String courseCode, courseFaculty, courseTitle, description;
    java.sql.Timestamp startDate2, endDate2;

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
        String errorMessage = "An error has occured. Add Course failed. Please try again";
        try {
            HttpSession session = request.getSession();

            courseCode = request.getParameter("courseCode");
            courseFaculty = request.getParameter("courseFaculty");
            courseTitle = request.getParameter("courseTitle");
            description = request.getParameter("description");

            String startDate = request.getParameter("startDate");
            Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            startDate2 = new Timestamp(startDate1.getTime());

            String endDate = request.getParameter("endDate");
            Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            endDate2 = new Timestamp(endDate1.getTime());

            String courseLeader = request.getParameter("courseLeader");
            String courseMod = request.getParameter("courseModerator");

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
            CourseManager cm = new CourseManager();
            if (request.getParameter("assign") != null) {
                cm.AddCourse(courseCode, courseFaculty, courseTitle, courseLeader, courseMod, startDate2, endDate2, description);
                courseList = cm.getAllCourse();
                request.setAttribute("leader", leader);
                request.setAttribute("moderator", moderator);
                request.setAttribute("facultyList", facultyList);
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
            } else if (request.getParameter("skip") != null) {
                {
                    cm.AddCourse(courseCode, courseFaculty, courseTitle, "", "", startDate2, endDate2, description);
                    courseList = cm.getAllCourse();
                    request.setAttribute("leader", leader);
                    request.setAttribute("moderator", moderator);
                    request.setAttribute("facultyList", facultyList);
                    request.setAttribute("courseList", courseList);
                    request.getRequestDispatcher("course.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
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
            CourseManager cm = new CourseManager();
            courseList = cm.getAllCourse();
            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("facultyList", facultyList);
            request.setAttribute("courseList", courseList);
            request.setAttribute("errorCode", 1);
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("course.jsp").forward(request, response);
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
