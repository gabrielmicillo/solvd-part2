package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.CityDao;
import com.solvd.sciencelab.dao.ClientDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.entities.LabSize;
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
        laboratoryService.updateLaboratory("Departamental", 870, "Perrando", "Medium", "Chicago");
        LOGGER.info(laboratoryDao.selectAll());

//        Deleting a row in city table
        LOGGER.info(cityDao.selectAll());
        cityDao.delete(1);
        LOGGER.info(cityDao.selectAll());

////        Sorting laboratories by experiment capacity
        LOGGER.info(laboratoryService.getAllLabsByExpCapacity());

////        Inserting a new laboratory (populating it first)
        laboratoryService.newLabWithNewSizeAndCity("Frangioli", 43, "Diminute", 60, "Machagai");
        laboratoryService.newLabWithExistingSizeAndCity("Municipal", 78, "Big", "Rosario");
        LOGGER.info(laboratoryDao.selectAll());

//        Filtering laboratories
        LOGGER.info(laboratoryService.retrieveLabsByExperimentCapacity(100));
    }
}
