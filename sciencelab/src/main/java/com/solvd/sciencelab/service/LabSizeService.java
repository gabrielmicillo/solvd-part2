package com.solvd.sciencelab.service;

import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.entities.LabSize;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabSizeService {
    private final LabSizeDao labSizeDao = new LabSizeDao();

    public LabSize getLabSizeById(long id) {
        LabSize l = new LabSize();
        try {
            l = labSizeDao.select(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    public List<LabSize> getAllLabSizes() {
        List<LabSize> labSizes = new ArrayList<>();
        try {
            labSizes = labSizeDao.selectAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return labSizes;
    }

    public void newLabSize(String labSize, int squareMeters) {
        LabSize newLabSize = new LabSize(labSize, squareMeters);
        try {
            labSizeDao.insert(newLabSize);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
