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
    
    public void AddCourse(String courseCode, String courseFaculty, String courseTitle, String courseLeader, String courseMod, Timestamp startDate, Timestamp endDate){
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblCourse values(?,?,?,?,?,?,?,1)");
            ps.setString(1, courseCode);
            ps.setString(2, courseFaculty);
            ps.setString(3, courseTitle);
            ps.setString(4, courseLeader);
            ps.setString(5, courseMod);
            ps.setTimestamp(6, startDate);
            ps.setTimestamp(7, endDate);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Course getCourseByID(int courseID){
        SqlConnection sql = new SqlConnection();
        Course course = new Course();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select * from tblCourse where id = ?");
            ps.setInt(1, courseID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseLeader(rs.getString("course_leader"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }
}
