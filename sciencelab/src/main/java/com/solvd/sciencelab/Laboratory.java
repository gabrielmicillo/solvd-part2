package com.solvd.sciencelab;

public class Laboratory {
    private int laboratoryId;
    private String name;
    private int expCapacity;
    private LabSize labsize;
    private City city;

    public Laboratory() {
    }

    public Laboratory(int laboratoryId, String name, int expCapacity, LabSize labsize, City city) {
        this.laboratoryId = laboratoryId;
        this.name = name;
        this.expCapacity = expCapacity;
        this.labsize = labsize;
        this.city = city;
    }

    public int getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpCapacity() {
        return expCapacity;
    }

    public void setExpCapacity(int expCapacity) {
        this.expCapacity = expCapacity;
    }

    public LabSize getLabsize() {
        return labsize;
    }

    public void setLabsize(LabSize labsize) {
        this.labsize = labsize;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "laboratoryId=" + laboratoryId +
                ", name='" + name + '\'' +
                ", expCapacity=" + expCapacity +
                ", labsize=" + labsize +
                ", city=" + city +
                '}';
    }
}