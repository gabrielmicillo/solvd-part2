package com.solvd.sciencelab.service;

import com.solvd.sciencelab.LabSize;
import com.solvd.sciencelab.dao.LabSizeDao;

import java.sql.SQLException;

public class LabSizeService {
    private LabSizeDao labSizeDao = new LabSizeDao();

    public LabSize getLabSizeById(long id) {
        LabSize l = new LabSize();
        try {
            l = labSizeDao.select(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

}
