/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
            PreparedStatement ps = conn.prepareStatement("SELECT tblCMR.cmr_code,tblCMR.student_count,tblCMR.comment, tblCMR.createDate,tblCMR.status,tblCMR.cmtstatus,\n"
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
                c.setAppstatus(rs.getInt("status"));
                c.setDate(rs.getDate("createDate"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllCMRByFaculty(String facultyCode) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty, c.start_date, c.end_date from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id and c.course_faculty = ?");
            ps.setString(1, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllApprovedCMR() {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id where cmr.status = 1");

            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllApprovedCMRByFaculty(String facultyCode) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id where cmr.status = 1 and c.course_faculty = ?");
            ps.setString(1, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllCommentedCMR() {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id where cmr.cmtstatus = 1");

            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllNotApprovedCMRbyLeader(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_leader = ? and cmr.status = 0");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllNotApprovedCMRbyLeaderByFaculty(String username, String facultyCode) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_leader = ? and cmr.status = 0 and c.course_faculty = ?");
            ps.setString(1, username);
            ps.setString(2, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllApprovedCMRbyLeader(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_leader = ? and cmr.status = 1");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllNotApprovedCMRbyMod(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_mod = ? and cmr.status = 0");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllNotApprovedCMRbyModByFaculty(String username, String facultyCode) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_mod = ? and cmr.status = 0 and c.course_faculty = ?");
            ps.setString(1, username);
            ps.setString(2, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllcommentedCMRbyLeader(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_leader = ? and cmr.status = 1 and cmr.cmtstatus = 1 ");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllApprovedCMRbyMod(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_mod = ? and cmr.status = 1");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public List<CMR> getAllCommentedCMRbyMod(String username) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select  cmr_code, student_count, comment, createDate, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_mod = ? and cmr.status = 1 and cmr.cmtstatus = 1");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR c = new CMR();
                c.setCmr_code(rs.getInt("cmr_code"));
                c.setStudent_count(rs.getInt("student_count"));
                c.setComment(rs.getString("comment"));
                c.setDate(rs.getDate("createDate"));
                c.setAppstatus(rs.getInt("status"));
                c.setCmtstatus(rs.getInt("cmtstatus"));
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

    public void AddCMR(CMR c) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("insert into tblCMR values(?,?,?,?,?,?,?)");
            ps.setInt(1, c.getCmr_code());
            ps.setInt(2, c.getStudent_count());
            ps.setString(3, c.getComment());
            ps.setString(4, c.getCreator());
            ps.setTimestamp(5, c.getCreateDate());
            ps.setInt(6, c.getAppstatus());
            ps.setInt(7, c.getCmtstatus());
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
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getCMRDetail ?");
            ps.setInt(1, cmr_code);
            rs = ps.executeQuery();
            while (rs.next()) {
                CMR_Detail cmrDetail = new CMR_Detail();
                cmrDetail.setCmr_code(rs.getInt("cmr_code"));
                cmrDetail.setCourseTitle(rs.getString("course_title"));
                cmrDetail.setFullname(rs.getString("fullname"));
                cmrDetail.setStudent_count(rs.getInt("student_count"));
                cmrDetail.setComment(rs.getString("comment"));
                cmrDetail.setCreator(rs.getString("creator"));
                cmrDetail.setCreateDate(rs.getDate("createDate"));
                cmrDetail.setAppStatus(rs.getInt("status"));
                cmrDetail.setCmtStatus(rs.getInt("cmtstatus"));
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

    public String getEmail(int role,String mod) {
        SqlConnection sql = new SqlConnection();
        String email = "";
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select email from tblEmployee where role = ? and username = ?");
            ps.setInt(1, role);
            ps.setString(2, mod);
            rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

    public void ApproveCMR(int cmr_code) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Update tblCMR Set status = 1 WHERE cmr_code = ?");
            ps.setInt(1, cmr_code);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CommentCMR(int cmr_code) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Update tblCMR Set cmtstatus = 1 WHERE cmr_code = ?");
            ps.setInt(1, cmr_code);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDLTComment(int cmr_code, String comment) {
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("Insert into tblComment Values(?,?)");
            ps.setInt(1, cmr_code);
            ps.setString(2, comment);
            int result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String findCommentCMR(int cmrCode) {
        SqlConnection sql = new SqlConnection();
        String comment = "";
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("select * from tblComment where cmr_code = ?");
            ps.setInt(1, cmrCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comment = rs.getString("comment");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    public int getNoOfCompletedCMRByFacultyByYearTS(Timestamp year1, Timestamp year2, String facultyCode) {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getCMRCompletedByFacultyByYear ?,?,?");
            ps.setTimestamp(1, year1);
            ps.setTimestamp(2, year2);
            ps.setString(3, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getNoOfCompletedCMRByFacultyByYear(String year1, String year2, String facultyCode) {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getCMRCompletedByFacultyByYear ?,?,?");
            ps.setString(1, year1);
            ps.setString(2, year2);
            ps.setString(3, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getNoOfCMRByFacultyByYearTS(Timestamp year1, Timestamp year2, String facultyCode) {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getAllCMRByFacultyByYear ?,?,?");
            ps.setTimestamp(1, year1);
            ps.setTimestamp(2, year2);
            ps.setString(3, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getNoOfCMRByFacultyByYear(String year1, String year2, String facultyCode) {
        int result = 0;
        SqlConnection sql = new SqlConnection();
        try {
            Connection conn = sql.connectSql();
            PreparedStatement ps = conn.prepareStatement("exec getAllCMRByFacultyByYear ?,?,?");
            ps.setString(1, year1);
            ps.setString(2, year2);
            ps.setString(3, facultyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("countNum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
