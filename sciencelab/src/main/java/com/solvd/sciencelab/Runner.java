package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.ExperimentDao;
import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.service.ExperimentService;
import com.solvd.sciencelab.service.LabSizeService;
import com.solvd.sciencelab.service.LaboratoryService;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
//        LabSizeService labSizeService = new LabSizeService();
//        System.out.println(labSizeService.getLabSizeById(1));
//        System.out.println(labSizeService.getAllLabSizes());
//        labSizeService.newLabSize("not so big", 21);
//        System.out.println(labSizeService.getAllLabSizes());

//        LaboratoryService laboratoryService = new LaboratoryService();
//        System.out.println(laboratoryService.getLaboratoryById(2));
//        System.out.println(laboratoryService.getLabByLabSizeId(1));

        ExperimentService experimentService = new ExperimentService();
        ExperimentDao experimentDao = new ExperimentDao();
        Experiment ex = new Experiment();
        ex = experimentDao.select(1);
        experimentService.cancelExperiment(ex);
    }
}
