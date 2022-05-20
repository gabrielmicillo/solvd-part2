package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.CityDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import com.solvd.sciencelab.service.LabSizeService;
import com.solvd.sciencelab.service.LaboratoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DaoRunner {
    private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

    public static void main(String[] args) throws SQLException {

//        LabSizeDao labSizeDao = new LabSizeDao();

//        LabSizeService labSizeService = new LabSizeService();
//        LOGGER.info(labSizeService.getLabSizeById(1));
//        LOGGER.info(labSizeService.getAllLabSizes());
//        System.out.println(labSizeService.getAllLabSizes());
//        labSizeService.newLabSize("not so big", 21);
//        LOGGER.info(labSizeService.getAllLabSizes());


        LaboratoryDao labDao = new LaboratoryDao();
        LabSizeDao labSizeDao = new LabSizeDao();
//        LaboratoryService laboratoryService = new LaboratoryService();
        CityDao cityDao = new CityDao();

        City city = new City("Machagai");
        cityDao.insert(city);
        city.setCityId(cityDao.getIdByCityName(city.getCityName()));

        LabSize labSize = new LabSize("diminute", 2);
        labSizeDao.insert(labSize);
        labSize.setLabSizeId(labSizeDao.getIdByLabSize(labSize.getLabSize()));

        Laboratory laboratory = new Laboratory("Frangioli", 4, labSize, city);

        labDao.insert(laboratory);
        LOGGER.info(labDao.select(5));
//        LOGGER.info(laboratoryService.getLaboratoryById(5));
////
//        LOGGER.info(laboratoryService.getLabByLabSizeId(1));
//        LOGGER.info(laboratoryService.getLaboratoryById(5));
//
//
//        LOGGER.info(labSizeDao.select(1));
//        ExperimentService experimentService = new ExperimentService();
//        ExperimentDao experimentDao = new ExperimentDao();
//        Experiment ex = new Experiment();
//        ex = experimentDao.select(1);
//        experimentService.cancelExperiment(ex);
    }
}
