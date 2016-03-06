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
import model.entity.CMR;
import model.entity.CMR_GradeData;
import model.entity.CMR_StaticalData;

/**
 *
 * @author DELL
 */
public class CMRManager {
    private List<CMR> cmrList = new ArrayList<>();
    private ResultSet rs;

    public List<CMR> getAllCMR() {
        SqlConnection sql = new SqlConnection();        
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Select* from tblCMR");
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("course_code"));                
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setStatus(rs.getInt("status"));
                cmrList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cmrList;
    }

    public void AddCMR(CMR c) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblCMR values(?,?,?,?)");
            ps.setInt(1,c.getCmr_code());        
            ps.setInt(2,c.getStudent_count());
            ps.setString(3,c.getComment());
            ps.setInt(4,c.getStatus());
            int result = ps.executeUpdate();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AddCMR_StaticalData(CMR_StaticalData s) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblStaticalData values(?,?,?,?,?)");
            ps.setInt(1,s.getCmr_id());        
            ps.setInt(2,s.getId_mark());
            ps.setInt(3,s.getMean());
            ps.setFloat(4,s.getMedian());
            ps.setInt(5,s.getStandard_deviation());
            int result = ps.executeUpdate();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void AddCMR_GradeData(CMR_GradeData g) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblGradeData values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,g.getCmr_id());        
            ps.setInt(2,g.getId_mark());
            ps.setInt(3,g.getMark0());
            ps.setInt(4,g.getMark1());
            ps.setInt(5,g.getMark2());
            ps.setInt(6,g.getMark3());
            ps.setInt(7,g.getMark4());
            ps.setInt(8,g.getMark5());
            ps.setInt(9,g.getMark6());
            ps.setInt(10,g.getMark7());
            ps.setInt(11,g.getMark8());
            ps.setInt(12,g.getMark9());
            int result = ps.executeUpdate();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
