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
import model.entity.CMR_Detail;
import model.manager.CMRManager;

/**
 *
 * @author W7
 */
@WebServlet(name = "GetCMRDetail", urlPatterns = {"/GetCMRDetail"})
public class GetCMRDetail extends HttpServlet {

    List<CMR_Detail> cmrDetail = new ArrayList<>();

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
        int courseID = Integer.valueOf(request.getParameter("courseID"));
        CMRManager cmrManage = new CMRManager();
        cmrDetail = cmrManage.getCMRDetailByCode(courseID);
        int i = 0;
        for (CMR_Detail cmr_Detail : cmrDetail) {
            i = i + 1;
            request.setAttribute("courseId", cmr_Detail.getCmr_code());
            request.setAttribute("courseTitle", cmr_Detail.getCourseTitle());
            request.setAttribute("courseLeader", cmr_Detail.getFullname());
            request.setAttribute("createDate", cmr_Detail.getCreateDate());
            request.setAttribute("creator", cmr_Detail.getCreator());
            request.setAttribute("comment", cmr_Detail.getComment());
            request.setAttribute("commentStatus", cmr_Detail.getCmtStatus());
            request.setAttribute("studentCount", cmr_Detail.getStudent_count());
            request.setAttribute("mean" + cmr_Detail.getStaticalData_id_mark() + "", cmr_Detail.getMean());
            request.setAttribute("median" + cmr_Detail.getStaticalData_id_mark() + "", cmr_Detail.getMedian());
            request.setAttribute("sd" + cmr_Detail.getStaticalData_id_mark() + "", cmr_Detail.getStandard_deviation());
            int k = 0;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark0());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark1());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark2());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark3());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark4());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark5());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark6());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark7());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark8());
            k = k + 1;
            request.setAttribute("mark_" + cmr_Detail.getId_mark() + "_" + k + "", cmr_Detail.getMark9());

        }
        request.getRequestDispatcher("cmr_detail.jsp").forward(request, response);
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
