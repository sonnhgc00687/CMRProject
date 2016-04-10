/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.CountCourse;
import model.entity.Faculty;
import model.entity.User;
import model.manager.CourseManager;
import model.manager.EncryptPassword;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author Son
 */
public class Login extends HttpServlet {

    private List<CountCourse> countCourseList = new ArrayList<>();

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
//        if (request.getSession() == null) {
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }else{
//            request.getRequestDispatcher("home.jsp").forward(request, response);
//        }
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        EncryptPassword encrypt = new EncryptPassword();
        String encryptedPassword = encrypt.encryptData(password);
        UserManager um = new UserManager();
        List<User> allUser = new ArrayList<>();
        List<User> leader = new ArrayList<>();
        List<User> moderator = new ArrayList<>();
        List<Faculty> facultyList = new ArrayList<>();
        allUser = um.getAllUsers();

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
        countCourseList = cm.getNoOfCourseByFaculty();

        User user = um.checkUser(username, encryptedPassword);

        if (user != null) {
            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("facultyList", facultyList);
            session.setAttribute("userSession", user.getUserName());
            session.setAttribute("userRole", user.getRole());
            request.setAttribute("username", username);
            request.getRequestDispatcher("faculty.jsp").forward(request, response);
        } else {
            System.out.println("Fail");
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
