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
import model.entity.CMR;
import model.entity.CMR_Detail;
import model.entity.CMR_GradeData;
import model.entity.CMR_StaticalData;
import model.entity.Course;
import model.manager.CMRManager;
import model.manager.CourseManager;
import model.manager.EmailSending;

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
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        CourseManager courseManager = new CourseManager();
        Course course = courseManager.getCourseByID(courseID);
        String title = course.getCourseTitle();
        String leader = course.getCourseLeader();
        String courseCode = course.getCourseCode();
        request.setAttribute("courseTitle", title);
        request.setAttribute("courseLeader", leader);
        request.setAttribute("courseId", courseID);
        request.getRequestDispatcher("new_cmr.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("id"));
            int studentCount = Integer.parseInt(request.getParameter("studentCount"));
            String comment = request.getParameter("comment");
            Date today = new Date();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
            String dateString = formatter.format(today);
            Date crDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            java.sql.Timestamp crDate2 = new Timestamp(crDate1.getTime());
            int appstatus = 0;
            int cmtstatus = 0;
            CMR c = new CMR(id, studentCount, comment, crDate2, appstatus, cmtstatus);
            CMRManager cmrm = new CMRManager();
            cmrm.AddCMR(c);
            for (int i = 1; i < 7; i++) {
                int id_mark = i;
                if (((request.getParameter("mean" + i).isEmpty()) || (request.getParameter("median" + i).isEmpty())) || (request.getParameter("sd" + i).isEmpty())) {
                } else {
                    int mean = Integer.parseInt(request.getParameter("mean" + i));
                    float median = Float.parseFloat(request.getParameter("median" + i));
                    int standard_deviation = Integer.parseInt(request.getParameter("sd" + i));
                    CMR_StaticalData s = new CMR_StaticalData(id, id_mark, mean, median, standard_deviation);
                    cmrm.AddCMR_StaticalData(s);
                }
                if ((request.getParameter("mark_" + i + "_" + 0).isEmpty()) || (request.getParameter("mark_" + i + "_" + 1).isEmpty()) || (request.getParameter("mark_" + i + "_" + 2).isEmpty()) || (request.getParameter("mark_" + i + "_" + 3).isEmpty()) || (request.getParameter("mark_" + i + "_" + 4).isEmpty()) || (request.getParameter("mark_" + i + "_" + 5).isEmpty()) || (request.getParameter("mark_" + i + "_" + 6).isEmpty()) || (request.getParameter("mark_" + i + "_" + 7).isEmpty()) || (request.getParameter("mark_" + i + "_" + 8).isEmpty()) || (request.getParameter("mark_" + i + "_" + 9).isEmpty())) {
                } else {
                    int mark0 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 0));
                    int mark1 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 1));
                    int mark2 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 2));
                    int mark3 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 3));
                    int mark4 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 4));
                    int mark5 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 5));
                    int mark6 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 6));
                    int mark7 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 7));
                    int mark8 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 8));
                    int mark9 = Integer.parseInt(request.getParameter("mark_" + i + "_" + 9));
                    CMR_GradeData g = new CMR_GradeData(id, id_mark, mark0, mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8, mark9);
                    cmrm.AddCMR_GradeData(g);
                }
            }
            List<String> emailList = new ArrayList<>();
            emailList = cmrm.getCMEmail();
            EmailSending email = new EmailSending();
            for (String emailItem : emailList) {
//                email.generateAndSendEmail(emailItem, "", "", "", "A new CMR has been add. Please comfirm it.");
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
