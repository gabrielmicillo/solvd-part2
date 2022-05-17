package com.solvd.sciencelab;

import com.solvd.sciencelab.service.LabSizeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class DaoRunner {
    private static final Logger LOGGER = LogManager.getLogger(DaoRunner.class);

    public static void main(String[] args) throws SQLException {

        LabSizeService labSizeService = new LabSizeService();
        LOGGER.info(labSizeService.getLabSizeById(1));
        LOGGER.info(labSizeService.getAllLabSizes());
//        labSizeService.newLabSize("not so big", 21);
//        LOGGER.info(labSizeService.getAllLabSizes());

//        LaboratoryService laboratoryService = new LaboratoryService();
//        LOGGER.info(laboratoryService.getLabByLabSizeId(1));
//        laboratoryService.newLaboratory("Frangioli", 5, 1, 1);
//        LOGGER.info(laboratoryService.getLaboratoryById(5));

//        ExperimentService experimentService = new ExperimentService();
//        ExperimentDao experimentDao = new ExperimentDao();
//        Experiment ex = new Experiment();
//        ex = experimentDao.select(1);
//        experimentService.cancelExperiment(ex);
    }
}
