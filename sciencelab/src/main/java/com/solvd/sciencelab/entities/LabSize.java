package com.solvd.sciencelab.entities;

public class LabSize {

    private int labSizeId;
    private String labSize;
    private int squareMeters;

    public LabSize() {
    }

    public LabSize(String labSize, int squareMeters) {
        this.labSize = labSize;
        this.squareMeters = squareMeters;
    }

    public LabSize(int labSizeId, String labSize, int squareMeters) {
        this.labSizeId = labSizeId;
        this.labSize = labSize;
        this.squareMeters = squareMeters;
    }

    public int getLabSizeId() {
        return labSizeId;
    }

    public void setLabSizeId(int labSizeId) {
        this.labSizeId = labSizeId;
    }

    public String getLabSize() {
        return labSize;
    }

    public void setLabSize(String labSize) {
        this.labSize = labSize;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    @Override
    public String toString() {
        return "LabSize{" +
                "labSize='" + labSize + '\'' +
                ", squareMeters=" + squareMeters +
                '}';
    }
}
