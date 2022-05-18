package com.solvd.sciencelab.entities;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class FinishedWork {

    @XmlElement
    public List<Order> orders = new ArrayList<>();
}
