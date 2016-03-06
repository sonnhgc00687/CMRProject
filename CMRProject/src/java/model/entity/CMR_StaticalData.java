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
public class CMR_StaticalData {

    private int id;
    private int cmr_id;
    private int id_mark;
    private int mean;
    private float median;
    private int standard_deviation;

    public CMR_StaticalData() {
    }

    public CMR_StaticalData(int cmr_id, int id_mark, int mean, float median, int standard_deviation) {
        this.cmr_id = cmr_id;
        this.id_mark = id_mark;
        this.mean = mean;
        this.median = median;
        this.standard_deviation = standard_deviation;
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

}
