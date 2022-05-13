package com.solvd.sciencelab;

public class LabSize {

    private String labSize;
    private int squareMeters;

    public LabSize() {
    }

    public LabSize(String labSize, int squareMeters) {
        this.labSize = labSize;
        this.squareMeters = squareMeters;
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
