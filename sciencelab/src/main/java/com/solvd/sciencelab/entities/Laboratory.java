package com.solvd.sciencelab.entities;

public class Laboratory {
    private String name;
    private int expCapacity;
    private LabSize labsize;
    private City city;

    public Laboratory() {
    }

    public Laboratory(String name, int expCapacity) {
        this.name = name;
        this.expCapacity = expCapacity;
    }

    public Laboratory(String name, int expCapacity, LabSize labsize, City city) {
        this.name = name;
        this.expCapacity = expCapacity;
        this.labsize = labsize;
        this.city = city;
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
                "name='" + name + '\'' +
                ", expCapacity=" + expCapacity +
                ", labsize=" + labsize +
                ", city=" + city +
                '}';
    }
}
