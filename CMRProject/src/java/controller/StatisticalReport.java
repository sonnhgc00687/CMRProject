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
import model.entity.Faculty;
import model.manager.CMRManager;
import model.manager.CourseManager;
import model.manager.FacultyManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "StatisticalReport", urlPatterns = {"/StatisticalReport"})
public class StatisticalReport extends HttpServlet {

    List<Faculty> facultyList = new ArrayList<>();

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
            out.println("<title>Servlet StatisticalReport</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatisticalReport at " + request.getContextPath() + "</h1>");
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
        try {
            CMRManager cm = new CMRManager();
            FacultyManager facultyManager = new FacultyManager();
            facultyList = facultyManager.getAllFaculty();           
            float percentage = 0;
            int noOfCompletedCMR = cm.getNoOfCompletedCMRByFacultyByYear("2016", "2017", "FPT2016");
            int noOfAllCMR = cm.getNoOfCMRByFacultyByYear("2016", "2017", "FPT2016");
            if (noOfAllCMR != 0) {
                percentage = (noOfCompletedCMR * 100) / noOfAllCMR;
            } else {
                percentage = 0;
            }
            CourseManager courseM = new CourseManager();
            int noOfCourseWithoutCLCM = courseM.getNoOfCourseWithoutCLCM();
            int noOfCourseWithoutCMR = courseM.getNoOfCourseWithoutCMR();
            int noOfCourseWithoutCompletedCMR = courseM.getNoOfCourseWithNotCompletedCMR();

            request.setAttribute("facultyList", facultyList);
            request.setAttribute("facultyTitle", "FPT2016");
            request.setAttribute("noOfCourseWithoutCLCM", noOfCourseWithoutCLCM);
            request.setAttribute("noOfCourseWithoutCMR", noOfCourseWithoutCMR);
            request.setAttribute("noOfCourseWithoutCompletedCMR", noOfCourseWithoutCompletedCMR);

            request.setAttribute("noOfCompletedCMR", noOfCompletedCMR);
            request.setAttribute("noOfAllCMR", noOfAllCMR);
            request.setAttribute("percentageCompleted", percentage);
            request.getRequestDispatcher("statis_exception_report.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
        try {
            CMRManager cm = new CMRManager();
            FacultyManager facultyManager = new FacultyManager();
            facultyList = facultyManager.getAllFaculty();
            
            String facultyCode = request.getParameter("courseFaculty");
            Faculty faculty = facultyManager.getFacultyByCode(facultyCode);
            String startDate = request.getParameter("startDate");
            Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            java.sql.Timestamp startDate2 = new Timestamp(startDate1.getTime());

            String endDate = request.getParameter("endDate");
            Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            java.sql.Timestamp endDate2 = new Timestamp(endDate1.getTime());
            float percentage = 0;
            int noOfCompletedCMR = cm.getNoOfCompletedCMRByFacultyByYearTS(startDate2, endDate2, facultyCode);
            int noOfAllCMR = cm.getNoOfCMRByFacultyByYearTS(startDate2, endDate2, facultyCode);
            if (noOfAllCMR != 0) {
                percentage = (noOfCompletedCMR * 100) / noOfAllCMR;
            } else {
                percentage = 0;
            }
            CourseManager courseM = new CourseManager();
            int noOfCourseWithoutCLCM = courseM.getNoOfCourseWithoutCLCM();
            int noOfCourseWithoutCMR = courseM.getNoOfCourseWithoutCMR();
            int noOfCourseWithoutCompletedCMR = courseM.getNoOfCourseWithNotCompletedCMR();

            request.setAttribute("facultyList", facultyList);
            request.setAttribute("facultyTitle", faculty.getFacultyTitle());
            
            request.setAttribute("noOfCourseWithoutCLCM", noOfCourseWithoutCLCM);
            request.setAttribute("noOfCourseWithoutCMR", noOfCourseWithoutCMR);
            request.setAttribute("noOfCourseWithoutCompletedCMR", noOfCourseWithoutCompletedCMR);

            request.setAttribute("noOfCompletedCMR", noOfCompletedCMR);
            request.setAttribute("noOfAllCMR", noOfAllCMR);
            request.setAttribute("percentageCompleted", percentage);
            request.getRequestDispatcher("statis_exception_report.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
