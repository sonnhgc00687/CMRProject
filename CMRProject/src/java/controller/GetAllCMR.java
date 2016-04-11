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
import model.entity.Faculty;
import model.manager.CMRManager;
import model.manager.FacultyManager;

/**
 *
 * @author Son
 */
@WebServlet(name = "GetAllCMR", urlPatterns = {"/GetAllCMR"})
public class GetAllCMR extends HttpServlet {

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
            out.println("<title>Servlet GetAllCMR</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetAllCMR at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String filter = request.getParameter("filter");
        String filterFaculty = request.getParameter("filterFaculty");
        FacultyManager facultyManager = new FacultyManager();
        Faculty faculty = facultyManager.getFacultyByCode(filterFaculty);
        request.setAttribute("filter", filter);
        request.setAttribute("facultyName", faculty.getFacultyTitle());
        CMRManager cmrManager = new CMRManager();
        String userName = (String) session.getAttribute("userSession");
        int userRole = (int) session.getAttribute("userRole");
        if (filterFaculty != null) {
            switch (userRole) {
                case 0:
                    listCMR = cmrManager.getAllCMRByFaculty(filterFaculty);
                    request.setAttribute("listCMR", listCMR);
                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                    break;
                case 1:
                    listCMR = cmrManager.getAllNotApprovedCMRbyLeaderByFaculty(userName, filterFaculty);
                    request.setAttribute("listCMR", listCMR);
                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                    break;
                case 2:
                    listCMR = cmrManager.getAllNotApprovedCMRbyModByFaculty(userName, filterFaculty);
                    request.setAttribute("listCMR", listCMR);
                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                    break;
                case 3:
                    listCMR = cmrManager.getAllApprovedCMRByFaculty(filterFaculty);
                    request.setAttribute("listCMR", listCMR);
                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                    break;
                case 4:
                    listCMR = cmrManager.getAllApprovedCMRByFaculty(filterFaculty);
                    request.setAttribute("listCMR", listCMR);
                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } else {
            if (filter == null) {
                switch (userRole) {
                    case 0:
                        listCMR = cmrManager.getAllCMR();
                        request.setAttribute("listCMR", listCMR);
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                    case 1:
                        listCMR = cmrManager.getAllNotApprovedCMRbyLeader(userName);
                        request.setAttribute("listCMR", listCMR);
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                    case 2:
                        listCMR = cmrManager.getAllNotApprovedCMRbyMod(userName);
                        request.setAttribute("listCMR", listCMR);
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                    case 3:
                        listCMR = cmrManager.getAllApprovedCMR();
                        request.setAttribute("listCMR", listCMR);
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                    case 4:
                        listCMR = cmrManager.getAllApprovedCMR();
                        request.setAttribute("listCMR", listCMR);
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                    default:
                        break;
                }
            } else {
                switch (userRole) {
                    case 0:
                        switch (filter) {
                            case "approved":
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("filterContent", "Approved CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "commented":
                                listCMR = cmrManager.getAllCommentedCMR();
                                request.setAttribute("filterContent", "Completed CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "all":
                                listCMR = cmrManager.getAllCMR();
                                request.setAttribute("filterContent", "All CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            default:
                                listCMR = cmrManager.getAllCMR();
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                        }
                    case 1:
                        switch (filter) {
                            case "commented":
                                listCMR = cmrManager.getAllcommentedCMRbyLeader(userName);
                                request.setAttribute("filterContent", "Completed CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "all":
                                listCMR = cmrManager.getAllNotApprovedCMRbyLeader(userName);
                                request.setAttribute("filterContent", "All CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            default:
                                listCMR = cmrManager.getAllNotApprovedCMRbyLeader(userName);
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                        }
                    case 2:
                        switch (filter) {
                            case "approved":
                                listCMR = cmrManager.getAllApprovedCMRbyMod(userName);
                                request.setAttribute("filterContent", "Approved CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "commented":
                                listCMR = cmrManager.getAllCommentedCMRbyMod(userName);
                                request.setAttribute("filterContent", "Completed CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "all":
                                listCMR = cmrManager.getAllNotApprovedCMRbyMod(userName);
                                request.setAttribute("filterContent", "All CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            default:
                                listCMR = cmrManager.getAllNotApprovedCMRbyMod(userName);
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                        }

                    case 3:
                        switch (filter) {
                            case "approved":
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("filterContent", "Approved CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "commented":
                                listCMR = cmrManager.getAllCommentedCMR();
                                request.setAttribute("filterContent", "Completed CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "all":
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("filterContent", "All CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            default:
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                        }
                    case 4:
                        switch (filter) {
                            case "approved":
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("filterContent", "Approved CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "commented":
                                listCMR = cmrManager.getAllCommentedCMR();
                                request.setAttribute("filterContent", "Completed CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            case "all":
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("filterContent", "All CMR");
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                            default:
                                listCMR = cmrManager.getAllApprovedCMR();
                                request.setAttribute("listCMR", listCMR);
                                request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                break;
                        }
                    default:
                        request.getRequestDispatcher("cmr.jsp").forward(request, response);
                        break;
                }
            }
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
