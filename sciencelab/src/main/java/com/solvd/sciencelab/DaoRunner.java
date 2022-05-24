package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.CityDao;
import com.solvd.sciencelab.dao.ClientDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import com.solvd.sciencelab.service.LaboratoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DaoRunner {
    private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

    public static void main(String[] args) throws SQLException {

        LabSizeDao labSizeDao = new LabSizeDao();
        CityDao cityDao = new CityDao();
        ClientDao clientDao = new ClientDao();
        LaboratoryDao laboratoryDao = new LaboratoryDao();

        LaboratoryService laboratoryService = new LaboratoryService();

//        Inserting a new laboratory size
        LOGGER.info(labSizeDao.selectAll());
        LabSize labSize = new LabSize("Intermedium", 60);
        labSizeDao.insert(labSize);
        LOGGER.info(labSizeDao.selectAll());

//        Retrieving all data from tables with created Dao
        LOGGER.info(labSizeDao.selectAll());
        LOGGER.info(cityDao.selectAll());
        LOGGER.info(clientDao.selectAll());
        LOGGER.info(laboratoryDao.selectAll());

//        Inserting a client
        Client client = new Client("Ryan", "Giggs");
        clientDao.insert(client);

//        Updating a row in city table
        LOGGER.info(cityDao.selectAll());
        City city = new City("Mallorca");
        cityDao.update(city, 1);
        LOGGER.info(cityDao.selectAll());

//        Updating a row in client table
        LOGGER.info(clientDao.selectAll());
        Client cli = new Client("Ezequiel", "Zorrilla");
        clientDao.update(cli, 1);
        LOGGER.info(clientDao.selectAll());

//        Updating a row in laboratory table
        LOGGER.info(laboratoryDao.selectAll());
        LabSize ls = new LabSize();
        labSize.setLabSizeId(1);
        City c = new City();
        city.setCityId(1);
        Laboratory laboratory = new Laboratory("National Lab", 78, ls, c);
        laboratoryDao.update(laboratory, 1);
        LOGGER.info(laboratoryDao.selectAll());

//        Deleting a row in city table
        LOGGER.info(cityDao.selectAll());
        cityDao.delete(1);
        LOGGER.info(cityDao.selectAll());

//        Sorting laboratories by experiment capacity
        LOGGER.info(laboratoryService.getAllLabsByExpCapacity());


//        Inserting a new laboratory (populating it first)
        City cit = new City("Machagai");
        cityDao.insert(cit);
        cit.setCityId(cityDao.getIdByCityName(cit.getCityName()));
        LabSize lSize = new LabSize("diminute", 2);
        labSizeDao.insert(lSize);
        lSize.setLabSizeId(labSizeDao.getIdByLabSize(lSize.getLabSize()));
        Laboratory lab = new Laboratory("Frangioli", 4, lSize, cit);
        laboratoryDao.insert(lab);
        LOGGER.info(laboratoryDao.selectAll());
    }
}
