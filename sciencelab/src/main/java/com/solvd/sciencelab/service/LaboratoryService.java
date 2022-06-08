package com.solvd.sciencelab.service;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.dao.*;
import com.solvd.sciencelab.designpatterns.JDBCFactory;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//        The only entity with SERVICE is Laboratory because it is the only fully
//        implemented entity with connections that can be populated with another
//        entities inside (it has 2 foreign keys: Lab size and City) and therefore the only one that
//        can interact with other DAOs. Implementing all DAOs and Services would be a waste of time because
//        it would be the same structure as this, over and over again.


public class LaboratoryService extends JDBCDao {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryService.class);
    private final ConnectionPool cp = getCp();

    private ILaboratoryDao laboratoryDao = (ILaboratoryDao) JDBCFactory.chooseDao("laboratory");

    private ILabSizeDao labSizeDao = (ILabSizeDao) JDBCFactory.chooseDao("labsize");

    private ICityDao cityDao = (ICityDao) JDBCFactory.chooseDao("city");


    public List<Laboratory> getAllLabsByExpCapacity() throws SQLException {
        return laboratoryDao.selectAll().stream()
                .sorted(Comparator.comparing(Laboratory::getExpCapacity))
                .collect(Collectors.toList());
    }

    public void updateLaboratory(String newLabName, int expCapacity, String oldLabName, String labSize, String cityName) throws SQLException {
        LabSize ls = new LabSize();
        ls.setLabSizeId(labSizeDao.getIdByLabSize(labSize));
        City c = new City();
        c.setCityId(cityDao.getIdByCityName(cityName));
        Laboratory laboratory = new Laboratory(newLabName, expCapacity, ls, c);
        laboratoryDao.update(laboratory, laboratoryDao.getIdByLabName(oldLabName));
    }

    public void newLabWithNewSizeAndCity(String labName, int expCapacity, String labSizeName, int squareMeters, String cityName) throws SQLException {
        City cit = new City(cityName);
        cityDao.insert(cit);
        cit.setCityId(cityDao.getIdByCityName(cit.getCityName()));
        LabSize lSize = new LabSize("labSizeName", squareMeters);
        labSizeDao.insert(lSize);
        lSize.setLabSizeId(labSizeDao.getIdByLabSize(lSize.getLabSize()));
        Laboratory lab = new Laboratory(labName, expCapacity, lSize, cit);
        laboratoryDao.insert(lab);
    }

    public void newLabWithExistingSizeAndCity(String labName, int expCapacity, String labSizeName, String cityName) throws SQLException {
        City cit = new City();
        cit.setCityId(cityDao.getIdByCityName(cityName));
        LabSize lSize = new LabSize();
        lSize.setLabSizeId(labSizeDao.getIdByLabSize(labSizeName));
        Laboratory lab = new Laboratory(labName, expCapacity, lSize, cit);
        laboratoryDao.insert(lab);
    }

    public List<Laboratory> retrieveLabsByExperimentCapacity(int expFilter) throws SQLException {
        List<Laboratory> laboratories = laboratoryDao.selectAll().stream()
                .filter(laboratory -> laboratory.getExpCapacity() > expFilter)
                .collect(Collectors.toList());
        return laboratories;
    }

}
