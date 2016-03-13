/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author DELL
 */
public class CMR {

    private int cmr_code;
    private int student_count;
    private String comment;
    private int status;
    private String course_code;
    private String course_title;
    private String course_faculty;

    public CMR() {
    }

    public CMR(int cmr_code, int student_count, String comment, int status) {
        this.cmr_code = cmr_code;
        this.student_count = student_count;
        this.comment = comment;
        this.status = status;
    }

    public CMR(int cmr_code, int student_count, String comment, int status, String course_code, String course_title, String course_faculty) {
        this.cmr_code = cmr_code;
        this.student_count = student_count;
        this.comment = comment;
        this.status = status;
        this.course_code = course_code;
        this.course_title = course_title;
        this.course_faculty = course_faculty;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
