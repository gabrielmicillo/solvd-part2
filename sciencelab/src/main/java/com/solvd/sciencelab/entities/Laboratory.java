package com.solvd.sciencelab.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"name", "expCapacity", "labsize", "city", "employees"})
public class Laboratory {
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
