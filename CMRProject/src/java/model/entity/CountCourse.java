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
public class CountCourse {
    private String facultyCode;
    private int courseNum;

    public CountCourse() {
    }

    public CountCourse(String facultyCode, int courseNum) {
        this.facultyCode = facultyCode;
        this.courseNum = courseNum;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }
    
    
}
