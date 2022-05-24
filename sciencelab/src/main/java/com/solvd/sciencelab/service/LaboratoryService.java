package com.solvd.sciencelab.service;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.dao.CityDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class LaboratoryService extends JDBCDao {
    private static Logger LOGGER = LogManager.getLogger(LaboratoryService.class);
    private final ConnectionPool cp = getCp();

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

//    public List<Laboratory> getAllLaboratoriesByExpCapacity() {
//        return laboratoryDao.selectAll().stream()
//                .sorted(Comparator.comparing(Laboratory::getExpCapacity))
//                .collect(Collectors.toList());
//    }

//    public void newLaboratory(Laboratory laboratory) throws SQLException {
//        try {
//            laboratory.setName(labName);
//            laboratory.setExpCapacity(expCapacity);
//            laboratory.setLabsize(labSizeDao.select(labIdLSModel));
//            laboratory.setCity(cityDao.getByLaboratoryId(labIdCityModel));
//            laboratoryDao.insert(laboratory);
//            LOGGER.info(laboratory);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void changeLaboratoryById(Laboratory laboratory, int id) throws SQLException {
        laboratoryDao.update(laboratory, id);
    }

    public void destroyLaboratory(int id) {
        laboratoryDao.delete(id);
    }
}
