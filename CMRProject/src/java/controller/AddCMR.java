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
import javax.servlet.http.HttpSession;
import model.entity.CMR;
import model.entity.CMR_Detail;
import model.entity.CMR_GradeData;
import model.entity.CMR_StaticalData;
import model.entity.Course;
import model.entity.Faculty;
import model.entity.User;
import model.manager.CMRManager;
import model.manager.CourseManager;
import model.manager.EmailSending;
import model.manager.FacultyManager;
import model.manager.UserManager;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddCMR", urlPatterns = {"/AddCMR"})
public class AddCMR extends HttpServlet {

    private List<CMR> listCMR = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();

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
        String errorMessage = "An error has occured. Submit CMR failed. Please try again.";
        try {
            HttpSession session = request.getSession();

            String creator = (String) session.getAttribute("userSession");
            int id = Integer.parseInt(request.getParameter("id"));
            int studentCount = Integer.parseInt(request.getParameter("studentCount"));
            String comment = request.getParameter("comment");
            Date today = new Date();
            System.out.println(today.toString());
            java.sql.Timestamp crDate2 = new Timestamp(today.getTime());
            int appstatus = 0;
            int cmtstatus = 0;
            CMR c = new CMR(id, studentCount, comment, creator, crDate2, appstatus, cmtstatus);
            CMRManager cmrm = new CMRManager();
            cmrm.AddCMR(c);
            CourseManager cm = new CourseManager();
            cm.addCMRtoCourse(id);
            for (int i = 1; i < 7; i++) {
                int id_mark = i;
                if (((request.getParameter("mean" + i).isEmpty()) || (request.getParameter("median" + i).isEmpty())) || (request.getParameter("sd" + i).isEmpty())) {
                } else {
                    float mean = Float.parseFloat(request.getParameter("mean" + i));
                    float median = Float.parseFloat(request.getParameter("median" + i));
                    float standard_deviation = Float.parseFloat(request.getParameter("sd" + i));
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
            String mod = cm.findModById(id);
            String emailMod = cmrm.getEmail(2,mod);
            EmailSending email = new EmailSending();
            email.generateAndSendEmail(emailMod, "group1cmr@gmail.com", "mainghia95", "CMR notification", "A new CMR has been submitted. Please comfirm it.");
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
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "commented":
                                    listCMR = cmrManager.getAllCommentedCMR();
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "all":
                                    listCMR = cmrManager.getAllCMR();
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
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "all":
                                    listCMR = cmrManager.getAllNotApprovedCMRbyLeader(userName);
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
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "commented":
                                    listCMR = cmrManager.getAllCommentedCMRbyMod(userName);
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "all":
                                    listCMR = cmrManager.getAllNotApprovedCMRbyMod(userName);
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
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "commented":
                                    listCMR = cmrManager.getAllCommentedCMR();
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "all":
                                    listCMR = cmrManager.getAllApprovedCMR();
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
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "commented":
                                    listCMR = cmrManager.getAllCommentedCMR();
                                    request.setAttribute("listCMR", listCMR);
                                    request.getRequestDispatcher("cmr.jsp").forward(request, response);
                                    break;
                                case "all":
                                    listCMR = cmrManager.getAllApprovedCMR();
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
        } catch (Exception e) {
            HttpSession session = request.getSession();
            request.setAttribute("errorCode", 1);
            request.setAttribute("message", errorMessage);
            String filter = request.getParameter("filter");
            String filterFaculty = request.getParameter("filterFaculty");
            String userName = (String) session.getAttribute("userSession");
            int userRole = (int) session.getAttribute("userRole");
            CourseManager cm = new CourseManager();

            List<User> allUser = new ArrayList<>();
            List<User> leader = new ArrayList<>();
            List<User> moderator = new ArrayList<>();
            List<Faculty> facultyList = new ArrayList<>();
            UserManager userManager = new UserManager();
            allUser = userManager.getAllUsers();
            FacultyManager facultyManager = new FacultyManager();
            facultyList = facultyManager.getAllFaculty();
            Faculty faculty = facultyManager.getFacultyByCode(filterFaculty);
            for (User user : allUser) {
                if (user.getRole() == 1) {
                    leader.add(user);
                } else if (user.getRole() == 2) {
                    moderator.add(user);
                }
            }

            request.setAttribute("leader", leader);
            request.setAttribute("moderator", moderator);
            request.setAttribute("facultyList", facultyList);
            request.setAttribute("filter", filter);
            request.setAttribute("facultyName", faculty.getFacultyTitle());
            if (filterFaculty != null) {
                switch (userRole) {
                    case 0:
                        courseList = cm.getAllCourseByFaculty(filterFaculty);
                        request.setAttribute("courseList", courseList);
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;
                    case 1:
                        courseList = cm.getAllCourseByCourseLeaderByFaculty(userName, filterFaculty);
                        request.setAttribute("courseList", courseList);
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;
                    case 2:
                        courseList = cm.getAllCourseByCourseModByFaculty(userName, filterFaculty);
                        request.setAttribute("courseList", courseList);
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;
                    case 3:
                        courseList = cm.getAllCourseByFaculty(filterFaculty);
                        request.setAttribute("courseList", courseList);
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;

                    case 4:
                        courseList = cm.getAllCourseByFaculty(filterFaculty);
                        request.setAttribute("courseList", courseList);
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("course.jsp").forward(request, response);
                        break;
                }
            } else {
                if (filter != null) {
                    switch (userRole) {
                        case 0:
                            switch (filter) {
                                case "noCMR":
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "CMR":
                                    courseList = cm.getAllCourseWithCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "all":
                                    courseList = cm.getAllCourse();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                default:
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                            }
                        case 1:
                            switch (filter) {
                                case "noCMR":
                                    courseList = cm.getAllCourseByCourseLeaderWithoutCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "CMR":
                                    courseList = cm.getAllCourseByCourseLeaderWithCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "all":
                                    courseList = cm.getAllCourseByCourseLeader(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                default:
                                    courseList = cm.getAllCourseByCourseLeaderWithoutCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                            }
                        case 2:
                            switch (filter) {
                                case "noCMR":
                                    courseList = cm.getAllCourseByCourseModWithoutCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "CMR":
                                    courseList = cm.getAllCourseByCourseModWithCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "all":
                                    courseList = cm.getAllCourseByCourseMod(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                default:
                                    courseList = cm.getAllCourseByCourseModWithoutCMR(userName);
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                            }

                        case 3:
                            switch (filter) {
                                case "noCMR":
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "CMR":
                                    courseList = cm.getAllCourseWithCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "all":
                                    courseList = cm.getAllCourse();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                default:
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                            }
                        case 4:
                            switch (filter) {
                                case "noCMR":
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "CMR":
                                    courseList = cm.getAllCourseWithCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                case "all":
                                    courseList = cm.getAllCourse();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                                default:
                                    courseList = cm.getAllCourseWithoutCMR();
                                    request.setAttribute("courseList", courseList);
                                    request.getRequestDispatcher("course.jsp").forward(request, response);
                                    break;
                            }
                        default:
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                    }
                } else {
                    switch (userRole) {
                        case 0:
                            courseList = cm.getAllCourseWithoutCMR();
                            request.setAttribute("courseList", courseList);
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                        case 1:
                            courseList = cm.getAllCourseByCourseLeaderWithoutCMR(userName);
                            request.setAttribute("courseList", courseList);
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                        case 2:
                            courseList = cm.getAllCourseByCourseModWithoutCMR(userName);
                            request.setAttribute("courseList", courseList);
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                        case 3:
                            courseList = cm.getAllCourseWithoutCMR();
                            request.setAttribute("courseList", courseList);
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;

                        case 4:
                            courseList = cm.getAllCourseWithoutCMR();
                            request.setAttribute("courseList", courseList);
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                        default:
                            request.getRequestDispatcher("course.jsp").forward(request, response);
                            break;
                    }
                }
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
