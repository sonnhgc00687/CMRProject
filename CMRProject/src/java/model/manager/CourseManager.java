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
    
    public void AddCourse(String courseCode, String courseTitle, String courseLeader, String courseMod, Timestamp startDate, Timestamp endDate){
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblCourse values(?,?,?,?,?,?,1)");
            ps.setString(1, courseCode);
            ps.setString(2, courseTitle);
            ps.setString(3, courseLeader);
            ps.setString(4, courseMod);
            ps.setTimestamp(5, startDate);
            ps.setTimestamp(6, endDate);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
