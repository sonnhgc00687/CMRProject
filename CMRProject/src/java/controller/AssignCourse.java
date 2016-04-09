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
import model.entity.Course;
import model.manager.CourseManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AssignCourse", urlPatterns = {"/AssignCourse"})
public class AssignCourse extends HttpServlet {

    private List<Course> courseList = new ArrayList<>();
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
        response.setContentType("text/html;charset=UTF-8");

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
        try {
            String courseCode = request.getParameter("courseCode");
            String courseTitle = request.getParameter("courseTitle");
            String courseLeader = request.getParameter("courseLeader");
            String courseMod = request.getParameter("courseModerator");
            String startDate = request.getParameter("startDate");
            Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            startDate2 = new Timestamp(startDate1.getTime());
            String endDate = request.getParameter("endDate");
            Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            endDate2 = new Timestamp(endDate1.getTime());
            String description = request.getParameter("description");

            CourseManager cm = new CourseManager();
            if (request.getParameter("assign") != null) {
                cm.updateCourse(courseTitle, courseLeader, courseMod, startDate2, endDate2, description, courseCode);
                courseList = cm.getAllCourse();
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("course.jsp").forward(request, response);
            } else if (request.getParameter("skip") != null) {
                {
                    courseList = cm.getAllCourse();
                    request.setAttribute("courseList", courseList);
                    request.getRequestDispatcher("course.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
