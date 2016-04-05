/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class CMR {

    private int cmr_code;
    private int student_count;
    private String comment;
    private java.sql.Timestamp createDate;
    private int appstatus;
    private int cmtstatus;
    private String course_code;
    private String course_title;
    private String course_faculty;

    public CMR() {
    }

    public CMR(int cmr_code, int student_count, String comment, java.sql.Timestamp createDate, int appstatus, int cmtstatus) {
        this.cmr_code = cmr_code;
        this.student_count = student_count;
        this.comment = comment;
        this.createDate = createDate;
        this.appstatus = appstatus;
        this.cmtstatus = cmtstatus;
    }

    public java.sql.Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.sql.Timestamp createDate) {
        this.createDate = createDate;
    }

    public CMR(int cmr_code, int student_count, String comment, int appstatus, String course_code, String course_title, String course_faculty) {
        this.cmr_code = cmr_code;
        this.student_count = student_count;
        this.comment = comment;
        this.appstatus = appstatus;
        this.course_code = course_code;
        this.course_title = course_title;
        this.course_faculty = course_faculty;
    }

    public int getAppstatus() {
        return appstatus;
    }

    public void setAppstatus(int appstatus) {
        this.appstatus = appstatus;
    }

    public int getCmtstatus() {
        return cmtstatus;
    }

    public void setCmtstatus(int cmtstatus) {
        this.cmtstatus = cmtstatus;
    }

    public int getCmr_code() {
        return cmr_code;
    }

    public void setCmr_code(int cmr_code) {
        this.cmr_code = cmr_code;
    }

    public int getStudent_count() {
        return student_count;
    }

    public void setStudent_count(int student_count) {
        this.student_count = student_count;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_faculty() {
        return course_faculty;
    }

    public void setCourse_faculty(String course_faculty) {
        this.course_faculty = course_faculty;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

}
