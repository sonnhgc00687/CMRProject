/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author Phuc
 */
public class Faculty {
    private String facultyCode;
    private String facultyTitle;
    private String facultyPVC;
    private String facultyDLT;
    private Date facultyStartDate;
    private Date facultyEndDate;
    private int facultyStatus;

    public Faculty() {
    }

    public Faculty(String facultyCode, String facultyTitle, String facultyPVC, String facultyDLT, Date facultyStartDate, Date facultyEndDate, int facultyStatus) {
        this.facultyCode = facultyCode;
        this.facultyTitle = facultyTitle;
        this.facultyPVC = facultyPVC;
        this.facultyDLT = facultyDLT;
        this.facultyStartDate = facultyStartDate;
        this.facultyEndDate = facultyEndDate;
        this.facultyStatus = facultyStatus;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyTitle() {
        return facultyTitle;
    }

    public void setFacultyTitle(String facultyTitle) {
        this.facultyTitle = facultyTitle;
    }

    public String getFacultyPVC() {
        return facultyPVC;
    }

    public void setFacultyPVC(String facultyPVC) {
        this.facultyPVC = facultyPVC;
    }

    public String getFacultyDLT() {
        return facultyDLT;
    }

    public void setFacultyDLT(String facultyDLT) {
        this.facultyDLT = facultyDLT;
    }

    public Date getFacultyStartDate() {
        return facultyStartDate;
    }

    public void setFacultyStartDate(Date facultyStartDate) {
        this.facultyStartDate = facultyStartDate;
    }

    public Date getFacultyEndDate() {
        return facultyEndDate;
    }

    public void setFacultyEndDate(Date facultyEndDate) {
        this.facultyEndDate = facultyEndDate;
    }

    public int getFacultyStatus() {
        return facultyStatus;
    }

    public void setFacultyStatus(int facultyStatus) {
        this.facultyStatus = facultyStatus;
    }
    
    
}
