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
import model.entity.User;
import model.manager.UserManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SearchStaff", urlPatterns = {"/SearchStaff"})
public class SearchStaff extends HttpServlet {

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
            out.println("<title>Servlet SearchStaff</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchStaff at " + request.getContextPath() + "</h1>");
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
        String findKey = request.getParameter("staffName");
        List<User> users = new ArrayList<>();
        List<User> leader = new ArrayList<>();
        List<User> moderator = new ArrayList<>();

        UserManager userManager = new UserManager();
        users = userManager.getAllUsersByName(findKey);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == 1) {
                users.get(i).setRoleName("Leader");
            } else if (users.get(i).getRole() == 2) {
                users.get(i).setRoleName("Moderator");
            } else if (users.get(i).getRole() == 3) {
                users.get(i).setRoleName("PVC");
            } else if (users.get(i).getRole() == 4) {
                users.get(i).setRoleName("DLT");
            } else if (users.get(i).getRole() == 0) {
                users.get(i).setRoleName("Administrator");
            }
        }
        request.setAttribute("leader", leader);
        request.setAttribute("moderator", moderator);
        request.setAttribute("users", users);
        request.getRequestDispatcher("staff.jsp").forward(request, response);
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
