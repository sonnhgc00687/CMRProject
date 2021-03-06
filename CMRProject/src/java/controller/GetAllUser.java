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
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Faculty;
import model.entity.User;
import model.manager.EmailSending;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author Son
 */
@WebServlet(name = "GetAllUser", urlPatterns = {"/GetAllUser"})
public class GetAllUser extends HttpServlet {

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
        doGet(request, response);
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
        getAllStaff(request, response);
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
            String username = request.getParameter("username");
            String fullname = request.getParameter("fullname");
            int role = Integer.valueOf(request.getParameter("role"));
            String email = request.getParameter("email");
            UserManager um = new UserManager();
            Random rng = new Random();
            String password = um.genPass(rng, "ABCDEFGHIKLMNOPQRSTUVWXYZ", 8);
            um.createUser(username, password, fullname, email, role);
            EmailSending es = new EmailSending();
            es.generateAndSendEmail(email, "group1cmr@gmail.com", "mainghia95", "Password delivered","Your account at CMR system has been created.<br/>This is your username: "+ username + "<br/>This is your password :"+ password+"<br/> Click this link to go CMR homepage: http://projectcmrapp.azurewebsites.net/");
            getAllStaff(request, response);
        } catch (Exception e) {
            request.setAttribute("errorCode", 1);
            String errorMessage = "An error has occured. Add staff failed. Please try again";
            request.setAttribute("message", errorMessage);
            getAllStaff(request, response);
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

    public void getAllStaff(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> users = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();

            UserManager userManager = new UserManager();
            users = userManager.getAllUsers();

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
