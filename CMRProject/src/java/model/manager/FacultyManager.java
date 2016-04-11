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
import model.entity.Faculty;

/**
 *
 * @author Phuc
 */
public class FacultyManager {

    Faculty faculty = new Faculty();
    List<Faculty> facultyList = new ArrayList<>();
    SqlConnection sql = new SqlConnection();

    public List<Faculty> getAllFaculty() {
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblFaculty");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyCode(rs.getString("faculty_code"));
                faculty.setFacultyTitle(rs.getString("faculty_title"));
                faculty.setFacultyPVC(rs.getString("faculty_pvc"));
                faculty.setFacultyDLT(rs.getString("faculty_dlt"));
                faculty.setFacultyStartDate(rs.getDate("start_date"));
                faculty.setFacultyEndDate(rs.getDate("end_date"));
                faculty.setFacultyStatus(rs.getInt("status"));
                facultyList.add(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facultyList;
    }

    public Faculty getFacultyByCode(String faculty_code) {
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblFaculty where faculty_code = ?");
            ps.setString(1, faculty_code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                faculty.setFacultyCode(rs.getString("faculty_code"));
                faculty.setFacultyTitle(rs.getString("faculty_title"));
                faculty.setFacultyPVC(rs.getString("faculty_pvc"));
                faculty.setFacultyDLT(rs.getString("faculty_dlt"));
                faculty.setFacultyStartDate(rs.getDate("start_date"));
                faculty.setFacultyEndDate(rs.getDate("end_date"));
                faculty.setFacultyStatus(rs.getInt("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faculty;
    }

    public Faculty getFacultyByTitle(String faculty_title) {
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblFaculty where faculty_title = ?");
            ps.setString(1, faculty_title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                faculty.setFacultyCode(rs.getString("faculty_code"));
                faculty.setFacultyTitle(rs.getString("faculty_title"));
                faculty.setFacultyPVC(rs.getString("faculty_pvc"));
                faculty.setFacultyDLT(rs.getString("faculty_dlt"));
                faculty.setFacultyStartDate(rs.getDate("start_date"));
                faculty.setFacultyEndDate(rs.getDate("end_date"));
                faculty.setFacultyStatus(rs.getInt("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faculty;
    }

    public boolean addFaculty(String facultyCode, String facultyTitle, Timestamp startDate, Timestamp endDate, String pvc, String dlt) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblFaculty values(?,?,?,?,?,?,1)");
            ps.setString(1, facultyCode);
            ps.setString(2, facultyTitle);
            ps.setString(3, pvc);
            ps.setString(4, dlt);
            ps.setTimestamp(5, startDate);
            ps.setTimestamp(6, endDate);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
