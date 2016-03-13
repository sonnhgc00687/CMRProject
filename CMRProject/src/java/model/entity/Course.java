/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Son
 */
public class Course {

    private int id;
    private String courseCode;
    private String courseFaculty;
    private String courseTitle;
    private String courseLeader;
    private String courseModerator;
    private Date courseStarted;
    private Date courseFinished;
    private int courseStatus;
    
    public Course() {
    }

    public Course(String courseCode, String courseFaculty, String courseTitle, String courseLeader, String courseModerator, Date courseStarted, Date courseFinished, int courseStatus) {
        this.courseCode = courseCode;
        this.courseFaculty = courseFaculty;
        this.courseTitle = courseTitle;
        this.courseLeader = courseLeader;
        this.courseModerator = courseModerator;
        this.courseStarted = courseStarted;
        this.courseFinished = courseFinished;
        this.courseStatus = courseStatus;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public void setCourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseLeader() {
        return courseLeader;
    }

    public void setCourseLeader(String courseLeader) {
        this.courseLeader = courseLeader;
    }

    public String getCourseModerator() {
        return courseModerator;
    }

    public void setCourseModerator(String courseModerator) {
        this.courseModerator = courseModerator;
    }

    public Date getCourseStarted() {
        return courseStarted;
    }

    public void setCourseStarted(Date courseStarted) {
        this.courseStarted = courseStarted;
    }

    public Date getCourseFinished() {
        return courseFinished;
    }

    public void setCourseFinished(Date courseFinished) {
        this.courseFinished = courseFinished;
    }

    public int getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(int courseStatus) {
        this.courseStatus = courseStatus;
    }

}
