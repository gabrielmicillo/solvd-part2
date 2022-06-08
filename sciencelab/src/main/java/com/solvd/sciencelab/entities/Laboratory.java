package com.solvd.sciencelab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"name", "expCapacity", "labsize", "city", "employees"})
@JsonPropertyOrder({"name", "expCapacity", "labsize", "city", "employees"})
public class Laboratory {

//    labSizeId and cityId just for MyBatis purposes only
    @JsonIgnore
    private int laboratoryId;
    @JsonIgnore
    private int labSizeId;
    @JsonIgnore
    private int cityId;
    @JsonProperty
    private String name;
    @JsonProperty("experiment capacity")
    private int expCapacity;
    @JsonProperty("laboratory size")
    private LabSize labsize;
    @JsonProperty
    private City city;

    //    Employee list just for JAXB and JSON purposes only
    @JsonProperty
    private List<Employee> employees;

    public Laboratory() {
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

    @XmlElement(name = "lab_name")
    public void setName(String name) {
        this.name = name;
    }

    public int getExpCapacity() {
        return expCapacity;
    }

    @XmlElement(name = "exp_capacity")
    public void setExpCapacity(int expCapacity) {
        this.expCapacity = expCapacity;
    }

    public LabSize getLabsize() {
        return labsize;
    }

    @XmlElement(name = "lab_size")
    public void setLabsize(LabSize labsize) {
        this.labsize = labsize;
    }

    public City getCity() {
        return city;
    }

    @XmlElement(name = "city_name")
    public void setCity(City city) {
        this.city = city;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @XmlElement(name = "employee")
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlTransient
    public int getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(int laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    @XmlTransient
    public int getLabSizeId() {
        return labSizeId;
    }

    public void setLabSizeId(int labSizeId) {
        this.labSizeId = labSizeId;
    }

    @XmlTransient
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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
