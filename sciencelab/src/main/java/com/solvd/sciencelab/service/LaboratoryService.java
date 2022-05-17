package com.solvd.sciencelab.service;

import com.solvd.sciencelab.dao.CityDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaboratoryService {
    private static Logger LOGGER = LogManager.getLogger(LaboratoryService.class);

    LaboratoryDao laboratoryDao = new LaboratoryDao();
    LabSizeDao labSizeDao = new LabSizeDao();
    CityDao cityDao = new CityDao();

    public Laboratory getLaboratoryById(long id) {
        Laboratory lab = new Laboratory();
        try {
            lab = laboratoryDao.select(id);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return lab;
    }

    public Laboratory getLabByLabSizeId(long id) {
        City c = new City();
        LabSize ls = new LabSize();
        Laboratory l = new Laboratory();
        try {
            c = cityDao.select(id);
            ls = labSizeDao.select(id);
            l = laboratoryDao.select(id);
            l.setCity(c);
            l.setLabsize(ls);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return l;
    }

    public List<Laboratory> getAllLaboratories() {
        return laboratoryDao.selectAll();
    }

    public List<Laboratory> getAllLaboratoriesByExpCapacity() {
        return laboratoryDao.selectAll().stream()
                .sorted(Comparator.comparing(Laboratory::getExpCapacity))
                .collect(Collectors.toList());
    }

    public void newLaboratory(String labName, int expCapacity, int labIdLSModel, int labIdCityModel) throws SQLException {
//        this method receives an example laboratory ID from a laboratory with the laboratory size and city that we want to add on the new register
        try {
            Laboratory laboratory = new Laboratory();
            laboratory.setName(labName);
            laboratory.setExpCapacity(expCapacity);
            laboratory.setLabsize(labSizeDao.getByLaboratoryId(labIdLSModel));
            laboratory.setCity(cityDao.getByLaboratoryId(labIdCityModel));
            laboratoryDao.insert(laboratory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeLaboratoryById(Laboratory laboratory, int id) {
        laboratoryDao.update(laboratory, id);
    }

    public void destroyLaboratory(Laboratory laboratory) {
        laboratoryDao.delete(laboratory);
    }
}
