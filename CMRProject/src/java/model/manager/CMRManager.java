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
import model.entity.CMR_Detail;
import model.entity.CMR_GradeData;
import model.entity.CMR_StaticalData;

/**
 *
 * @author DELL
 */
public class CMRManager {

    private List<CMR> cmrList = new ArrayList<>();
    private List<CMR_Detail> cmrDetailList = new ArrayList<>();
    private ResultSet rs;

    public List<CMR> getAllCMR() {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("SELECT tblCMR.cmr_code,tblCMR.student_count,tblCMR.comment,tblCMR.status,\n"
                    + "tblCourse.course_code,tblCourse.course_title,tblCourse.course_faculty\n"
                    + "FROM tblCMR\n"
                    + "INNER JOIN tblCourse\n"
                    + "ON tblCMR.cmr_code = tblCourse.id");
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setStatus(rs.getInt("status"));
                c.setCourse_code(rs.getString("course_code"));
                c.setCourse_title(rs.getString("course_title"));
                c.setCourse_faculty(rs.getString("course_faculty"));
                cmrList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cmrList;
    }

    public List<CMR> getAllApprovedCMRbyUsername(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, cmr.[status] from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id inner join tblEmployee e on c.course_mod = e.username where e.username = ? and cmr.status = 1");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
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
            ps.setInt(1, c.getCmr_code());
            ps.setInt(2, c.getStudent_count());
            ps.setString(3, c.getComment());
            ps.setInt(4, c.getStatus());
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
            ps.setInt(1, s.getCmr_id());
            ps.setInt(2, s.getId_mark());
            ps.setInt(3, s.getMean());
            ps.setFloat(4, s.getMedian());
            ps.setInt(5, s.getStandard_deviation());
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
            ps.setInt(1, g.getCmr_id());
            ps.setInt(2, g.getId_mark());
            ps.setInt(3, g.getMark0());
            ps.setInt(4, g.getMark1());
            ps.setInt(5, g.getMark2());
            ps.setInt(6, g.getMark3());
            ps.setInt(7, g.getMark4());
            ps.setInt(8, g.getMark5());
            ps.setInt(9, g.getMark6());
            ps.setInt(10, g.getMark7());
            ps.setInt(11, g.getMark8());
            ps.setInt(12, g.getMark9());
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CMR_Detail> getCMRDetailByCode(int cmr_code) {
        SqlConnection sql = new SqlConnection();
//        CMR_Detail cmrDetail = new CMR_Detail();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getCMRDetail ?");
            ps.setInt(1, cmr_code);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR_Detail cmrDetail = new CMR_Detail();
                cmrDetail.setCmr_code(rs.getInt("cmr_code"));
                cmrDetail.setStudent_count(rs.getInt("student_count"));
                cmrDetail.setComment(rs.getString("comment"));
                cmrDetail.setStatus(rs.getInt("status"));
                cmrDetail.setStaticalData_id_mark(rs.getInt("staticalData_id_mark"));
                cmrDetail.setMean(rs.getInt("mean"));
                cmrDetail.setMedian(rs.getFloat("median"));
                cmrDetail.setStandard_deviation(rs.getInt("standard_deviation"));
                cmrDetail.setId_mark(rs.getInt("id_mark"));
                cmrDetail.setMark0(rs.getInt("mark0"));
                cmrDetail.setMark1(rs.getInt("mark1"));
                cmrDetail.setMark2(rs.getInt("mark2"));
                cmrDetail.setMark3(rs.getInt("mark3"));
                cmrDetail.setMark4(rs.getInt("mark4"));
                cmrDetail.setMark5(rs.getInt("mark5"));
                cmrDetail.setMark6(rs.getInt("mark6"));
                cmrDetail.setMark7(rs.getInt("mark7"));
                cmrDetail.setMark8(rs.getInt("mark8"));
                cmrDetail.setMark9(rs.getInt("mark9"));
                cmrDetailList.add(cmrDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cmrDetailList;
    }

}
