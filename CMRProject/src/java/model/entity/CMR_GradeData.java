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
public class CMR_GradeData {

    private int id;
    private int cmr_id;
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

    public CMR_GradeData() {
    }

    public CMR_GradeData(int cmr_id, int id_mark, int mark0, int mark1, int mark2, int mark3, int mark4, int mark5, int mark6, int mark7, int mark8, int mark9) {        
        this.cmr_id = cmr_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCmr_id() {
        return cmr_id;
    }

    public void setCmr_id(int cmr_id) {
        this.cmr_id = cmr_id;
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
