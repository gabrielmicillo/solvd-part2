package com.solvd.sciencelab.service;

import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.entities.LabSize;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabSizeService {
    private static Logger LOGGER = LogManager.getLogger(LabSizeService.class);
    private final LabSizeDao labSizeDao = new LabSizeDao();

    public LabSize getLabSizeById(long id) {
        LabSize l = new LabSize();
        try {
            l = labSizeDao.select(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return l;
    }

    public List<LabSize> getAllLabSizes() {
        List<LabSize> labSizes = new ArrayList<>();
        try {
            labSizes = labSizeDao.selectAll();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return labSizes;
    }

    public void newLabSize(String labSize, int squareMeters) {
        LabSize newLabSize = new LabSize(labSize, squareMeters);
        try {
            labSizeDao.insert(newLabSize);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

}
