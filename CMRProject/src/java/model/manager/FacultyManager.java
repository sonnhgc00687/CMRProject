/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.Faculty;

/**
 *
 * @author Phuc
 */
public class FacultyManager {
    List<Faculty> facultyList = new ArrayList<>();
    SqlConnection sql = new SqlConnection();
    
    public List<Faculty> getAllFaculty(){
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
}
