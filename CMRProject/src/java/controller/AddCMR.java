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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.CMR;
import model.entity.CMR_GradeData;
import model.entity.CMR_StaticalData;
import model.manager.CMRManager;
import model.manager.CourseManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddCMR", urlPatterns = {"/AddCMR"})
public class AddCMR extends HttpServlet {

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
        request.getRequestDispatcher("addNewCMR.jsp").forward(request, response);
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
        try {
            String courseCode = request.getParameter("courseCode");
            int studentCount = Integer.parseInt(request.getParameter("studentCount"));
            String comment = request.getParameter("comment");
            int status = 0;
            CMR c = new CMR(courseCode, studentCount, comment, status);
            CourseManager courseManager = new CourseManager();
            CMRManager cmrm = new CMRManager();
            cmrm.AddCMR(c);
            for (int i = 1; i < 7; i++) {
                int id_mark = i;
                int mean = Integer.parseInt(request.getParameter("mean" + i + ""));
                float median = Float.parseFloat(request.getParameter("median" + i + ""));
                int standard_deviation = Integer.parseInt(request.getParameter("sd" + i + ""));
                CMR_StaticalData s = new CMR_StaticalData(courseCode, id_mark, mean, median, standard_deviation);
                cmrm.AddCMR_StaticalData(s);

                int mark0 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 0 + ""));
                int mark1 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 1 + ""));
                int mark2 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 2 + ""));
                int mark3 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 3 + ""));
                int mark4 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 4 + ""));
                int mark5 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 5 + ""));
                int mark6 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 6 + ""));
                int mark7 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 7 + ""));
                int mark8 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 8 + ""));
                int mark9 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 9 + ""));
                CMR_GradeData g = new CMR_GradeData(courseCode, id_mark, mark0, mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8, mark9);
                cmrm.AddCMR_GradeData(g);
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
