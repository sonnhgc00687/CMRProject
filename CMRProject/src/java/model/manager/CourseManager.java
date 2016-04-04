/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.entity.CountCourse;
import model.entity.Course;

/**
 *
 * @author Son
 */
public class CourseManager {

    private List<Course> courseList = new ArrayList<>();
    private ResultSet rs;

    public List<Course> getAllCourse() {
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblCourse");
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setCourseCode(rs.getString("course_code"));
                c.setCourseTitle(rs.getString("course_title"));
                c.setCourseLeader(rs.getString("course_leader"));
                c.setCourseModerator(rs.getString("course_mod"));
                c.setCourseStarted(rs.getDate("start_date"));
                c.setCourseFinished(rs.getDate("end_date"));
                c.setCourseStatus(rs.getInt("status"));
                courseList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public List<Course> getAllCourseByTitle(String course_title) {
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblCourse where course_title like ? ");
            String title = "%" + course_title + "%";
            ps.setString(1, title);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setCourseCode(rs.getString("course_code"));
                c.setCourseTitle(rs.getString("course_title"));
                c.setCourseLeader(rs.getString("course_leader"));
                c.setCourseModerator(rs.getString("course_mod"));
                c.setCourseStarted(rs.getDate("start_date"));
                c.setCourseFinished(rs.getDate("end_date"));
                c.setCourseStatus(rs.getInt("status"));
                courseList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public List<Course> getAllCourseByCourseLeader(String course_leader) {
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblCourse where course_leader = ?");
            ps.setString(1, course_leader);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setCourseCode(rs.getString("course_code"));
                c.setCourseTitle(rs.getString("course_title"));
                c.setCourseLeader(rs.getString("course_leader"));
                c.setCourseModerator(rs.getString("course_mod"));
                c.setCourseStarted(rs.getDate("start_date"));
                c.setCourseFinished(rs.getDate("end_date"));
                c.setCourseStatus(rs.getInt("status"));
                courseList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public List<Course> getAllCourseByCourseMod(String course_mod) {
        SqlConnection sql = new SqlConnection();

        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblCourse where course_mod = ?");
            ps.setString(1, course_mod);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setCourseCode(rs.getString("course_code"));
                c.setCourseTitle(rs.getString("course_title"));
                c.setCourseLeader(rs.getString("course_leader"));
                c.setCourseModerator(rs.getString("course_mod"));
                c.setCourseStarted(rs.getDate("start_date"));
                c.setCourseFinished(rs.getDate("end_date"));
                c.setCourseStatus(rs.getInt("status"));
                courseList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public void AddCourse(String courseCode, String courseFaculty, String courseTitle, String courseLeader, String courseMod, Timestamp startDate, Timestamp endDate, String description) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblCourse values(?,?,?,?,?,?,?,?,1)");
            ps.setString(1, courseCode);
            ps.setString(2, courseFaculty);
            ps.setString(3, courseTitle);
            ps.setString(4, courseLeader);
            ps.setString(5, courseMod);
            ps.setTimestamp(6, startDate);
            ps.setTimestamp(7, endDate);
            ps.setString(8, description);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Course getCourseByID(int courseID) {
        SqlConnection sql = new SqlConnection();
        Course course = new Course();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getCourseDetail ?");
            ps.setInt(1, courseID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseFaculty(rs.getString("faculty_title"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseLeader(rs.getString("course_leader"));
                course.setCourseModerator(rs.getString("course_mod"));
                course.setCourseStarted(rs.getDate("start_date"));
                course.setCourseFinished(rs.getDate("end_date"));
                course.setDescription(rs.getString("description"));
                course.setCourseStatus(rs.getInt("status"));
            } else {
                PreparedStatement ps2 = conn.prepareStatement("exec getCourseDetailWithoutCLCM ?");
                ps2.setInt(1, courseID);
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    course.setCourseCode(rs2.getString("course_code"));
                    course.setCourseFaculty(rs2.getString("faculty_title"));
                    course.setCourseTitle(rs2.getString("course_title"));
                    course.setCourseLeader("");
                    course.setCourseModerator("");
                    course.setCourseStarted(rs2.getDate("start_date"));
                    course.setCourseFinished(rs2.getDate("end_date"));
                    course.setDescription(rs2.getString("description"));
                    course.setCourseStatus(rs2.getInt("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    public int getNoOfCourseWithoutCLCM() {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getAllCourseWithoutCLorCM");
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getNoOfCourseWithoutCMR() {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getAllCourseWithoutCMR");
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getNoOfCourseWithNotCompletedCMR() {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getAllCourseWithNotCompletedCMR");
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public CountCourse getNoOfCourseByFaculty() {
        SqlConnection sql = new SqlConnection();
        CountCourse cc = new CountCourse();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getNumberOfCourseByFaculty");
            rs = ps.executeQuery();
            while (rs.next()) {
                cc = new CountCourse(rs.getString("faculty_title"), rs.getInt("countNum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cc;
    }

    public void AssignCourse(String courseCode, String courseLeader, String courseMod) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Update tblCourse set course_leader = ?, course_mod = ? where course_code = ?");
            ps.setString(3, courseCode);
            ps.setString(1, courseLeader);
            ps.setString(2, courseMod);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
