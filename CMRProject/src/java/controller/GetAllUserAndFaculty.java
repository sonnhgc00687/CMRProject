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
import model.entity.User;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author Phuc
 */
@WebServlet(name = "GetAllUserAndFaculty", urlPatterns = {"/GetAllUserAndFaculty"})
public class GetAllUserAndFaculty extends HttpServlet {

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
        List<User> allUser = new ArrayList<>();
        List<User> leader = new ArrayList<>();
        List<User> moderator = new ArrayList<>();
        List<User> pvcList = new ArrayList<>();
        List<User> dltList = new ArrayList<>();
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
            } else if (user.getRole() == 3) {
                pvcList.add(user);
            } else if (user.getRole() == 4) {
                dltList.add(user);
            }
        }

        request.setAttribute("leader", leader);
        request.setAttribute("moderator", moderator);
        request.setAttribute("pvcList", pvcList);
        request.setAttribute("dltList", dltList);
        request.setAttribute("facultyList", facultyList);
        request.getRequestDispatcher("faculty.jsp").forward(request, response);
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
            String facultyCode = request.getParameter("facultyCode");
            String facultyTitle = request.getParameter("facultyTitle");
            String startDate = request.getParameter("startDate");
            Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            java.sql.Timestamp startDate2 = new Timestamp(startDate1.getTime());

            String endDate = request.getParameter("endDate");
            Date endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            java.sql.Timestamp endDate2 = new Timestamp(endDate1.getTime());

            String pvc = request.getParameter("pvc");
            String dlt = request.getParameter("dlt");

            FacultyManager fm = new FacultyManager();
            fm.addFaculty(facultyCode, facultyTitle, startDate2, endDate2, pvc, dlt);
            List<User> allUser = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();
            List<User> pvcList = new ArrayList<>();
            List<User> dltList = new ArrayList<>();
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
                } else if (user.getRole() == 3) {
                    pvcList.add(user);
                } else if (user.getRole() == 4) {
                    dltList.add(user);
                }
            }

            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("pvcList", pvcList);
            request.setAttribute("dltList", dltList);
            request.setAttribute("facultyList", facultyList);
            request.getRequestDispatcher("faculty.jsp").forward(request, response);
        } catch (Exception e) {
            String errorMessage = "An error has occured. Add Faculty failed. Please try again";
            List<User> allUser = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();
            List<User> pvcList = new ArrayList<>();
            List<User> dltList = new ArrayList<>();
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
                } else if (user.getRole() == 3) {
                    pvcList.add(user);
                } else if (user.getRole() == 4) {
                    dltList.add(user);
                }
            }

            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("pvcList", pvcList);
            request.setAttribute("dltList", dltList);
            request.setAttribute("facultyList", facultyList);
            request.setAttribute("errorCode", 1);
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("faculty.jsp").forward(request, response);
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
