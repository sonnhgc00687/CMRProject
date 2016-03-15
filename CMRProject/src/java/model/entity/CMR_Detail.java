/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author W7
 */
public class CMR_Detail {

    private int cmr_code;
    private String courseTitle;
    private String fullname;
    private int student_count;
    private String comment;
    private int status;
    private int staticalData_id_mark;
    private int mean;
    private float median;
    private int standard_deviation;
    private int id_mark;
    private int mark0;
    private int mark1;
    private int mark2;
    private int mark3;
    private int mark4;
    private int mark5;
    private int mark6;
    private int mark7;
    private int mark8;
    private int mark9;

    public CMR_Detail(int cmr_code, String courseTitle, String fullname, int student_count, String comment, int status, int staticalData_id_mark, int mean, float median, int standard_deviation, int id_mark, int mark0, int mark1, int mark2, int mark3, int mark4, int mark5, int mark6, int mark7, int mark8, int mark9) {
        this.cmr_code = cmr_code;
        this.courseTitle = courseTitle;
        this.fullname = fullname;
        this.student_count = student_count;
        this.comment = comment;
        this.status = status;
        this.staticalData_id_mark = staticalData_id_mark;
        this.mean = mean;
        this.median = median;
        this.standard_deviation = standard_deviation;
        this.id_mark = id_mark;
        this.mark0 = mark0;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
        this.mark6 = mark6;
        this.mark7 = mark7;
        this.mark8 = mark8;
        this.mark9 = mark9;
    }

    public CMR_Detail() {
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public int getStaticalData_id_mark() {
        return staticalData_id_mark;
    }

    public void setStaticalData_id_mark(int staticalData_id_mark) {
        this.staticalData_id_mark = staticalData_id_mark;
    }

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public float getMedian() {
        return median;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public int getStandard_deviation() {
        return standard_deviation;
    }

    public void setStandard_deviation(int standard_deviation) {
        this.standard_deviation = standard_deviation;
    }

    public int getId_mark() {
        return id_mark;
    }

    public void setId_mark(int id_mark) {
        this.id_mark = id_mark;
    }

    public int getMark0() {
        return mark0;
    }

    public void setMark0(int mark0) {
        this.mark0 = mark0;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public int getMark4() {
        return mark4;
    }

    public void setMark4(int mark4) {
        this.mark4 = mark4;
    }

    public int getMark5() {
        return mark5;
    }

    public void setMark5(int mark5) {
        this.mark5 = mark5;
    }

    public int getMark6() {
        return mark6;
    }

    public void setMark6(int mark6) {
        this.mark6 = mark6;
    }

    public int getMark7() {
        return mark7;
    }

    public void setMark7(int mark7) {
        this.mark7 = mark7;
    }

    public int getMark8() {
        return mark8;
    }

    public void setMark8(int mark8) {
        this.mark8 = mark8;
    }

    public int getMark9() {
        return mark9;
    }

    public void setMark9(int mark9) {
        this.mark9 = mark9;
    }
    
    
}
