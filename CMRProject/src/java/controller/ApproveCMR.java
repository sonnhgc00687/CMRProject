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
import model.entity.CMR;
import model.manager.CMRManager;
import model.manager.CourseManager;
import model.manager.EmailSending;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ApproveCMR", urlPatterns = {"/ApproveCMR"})
public class ApproveCMR extends HttpServlet {

    List<CMR> listCMR = new ArrayList<>();

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
            out.println("<title>Servlet ApproveCMR</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApproveCMR at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("btnComment") != null) {
            HttpSession session = request.getSession();
            String commentOfDLT = request.getParameter("DLTcomment");
            String userName = (String) session.getAttribute("userSession");
            int cmr_code = Integer.parseInt(request.getParameter("id"));
            CMRManager cm = new CMRManager();
            cm.CommentCMR(cmr_code);
            cm.addDLTComment(cmr_code, commentOfDLT);
            CourseManager courseManager = new CourseManager();
            String mod = courseManager.findModById(cmr_code);
            String emailMod = cm.getEmail(2,mod);
            EmailSending email = new EmailSending();
            email.generateAndSendEmail(emailMod, "group1cmr@gmail.com", "mainghia95", "CMR notification", "A new CMR has been responded by your falcuty's DLT. Please check it out.");
            String leader = courseManager.findLeaderById(cmr_code);
            String emailLeader = cm.getEmail(1, leader);
            email.generateAndSendEmail(emailLeader, "group1cmr@gmail.com", "mainghia95", "CMR notification", "A new CMR has been responded by your falcuty's DLT. Please check it out.");
            listCMR = cm.getAllCommentedCMR();
            request.setAttribute("listCMR", listCMR);
            request.getRequestDispatcher("cmr.jsp").forward(request, response);
        } else {
            try {
                HttpSession session = request.getSession();
                String userName = (String) session.getAttribute("userSession");
                int cmr_code = Integer.parseInt(request.getParameter("id"));
                CMRManager cm = new CMRManager();
                cm.ApproveCMR(cmr_code);
                CourseManager courseManager = new CourseManager();
                String dlt = courseManager.findDLTById(cmr_code);
                String emaildlt = cm.getEmail(4,dlt);
                EmailSending em = new EmailSending();
                em.generateAndSendEmail(emaildlt, "group1cmr@gmail.com", "mainghia95", "New CMR approved", "A new CMR of your Faculty has been approved. Please check it out");
                listCMR = cm.getAllNotApprovedCMRbyMod(userName);
                request.setAttribute("listCMR", listCMR);
                request.getRequestDispatcher("cmr.jsp").forward(request, response);
            } catch (Exception e) {
                CMRManager cm = new CMRManager();
                HttpSession session = request.getSession();
                String userName = (String) session.getAttribute("userSession");
                String errorMessage = "An error has occured. Approve CMR failed. Please try again";
                listCMR = cm.getAllNotApprovedCMRbyMod(userName);
                request.setAttribute("errorCode", 1);
                request.setAttribute("message", errorMessage);
                request.setAttribute("listCMR", listCMR);
                request.getRequestDispatcher("cmr.jsp").forward(request, response);
            }
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
