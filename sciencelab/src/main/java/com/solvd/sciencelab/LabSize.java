package com.solvd.sciencelab;

public class LabSize {
    private int labSizeId;
    private String labSize;
    private int squareMeters;

    public LabSize() {
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
                "labSizeId=" + labSizeId +
                ", labSize='" + labSize + '\'' +
                ", squareMeters=" + squareMeters +
                '}';
    }
}
