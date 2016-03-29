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
import model.entity.Course;
import model.entity.Faculty;
import model.entity.User;
import model.manager.CourseManager;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author Dell
 */
@WebServlet(name = "GetCourseDetail", urlPatterns = {"/GetCourseDetail"})
public class GetCourseDetail extends HttpServlet {

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
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        Course course = new Course();
        CourseManager manager = new CourseManager();
        course = manager.getCourseByID(courseID);
        List<User> leader = new ArrayList<>();
        List<User> moderator = new ArrayList<>();
        List<User> allUser = new ArrayList<>();
        List<Faculty> facultyList = new ArrayList<>();
        FacultyManager facultyManager = new FacultyManager();
        facultyList = facultyManager.getAllFaculty();

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
        request.setAttribute("facultyList", facultyList);
        request.setAttribute("id", course.getId());
        request.setAttribute("courseCode", course.getCourseCode());
        request.setAttribute("courseFaculty", course.getCourseFaculty());
        request.setAttribute("courseTitle", course.getCourseTitle());
        request.setAttribute("courseLeader", course.getCourseLeader());
        request.setAttribute("courseModerator", course.getCourseModerator());
        request.setAttribute("courseStarted", course.getCourseStarted());
        request.setAttribute("courseFinished", course.getCourseFinished());
        request.setAttribute("description", course.getDescription());
        request.setAttribute("courseStatus", course.getCourseStatus());
        request.getRequestDispatcher("course_detail.jsp").forward(request, response);
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
