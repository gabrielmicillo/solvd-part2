package com.solvd.sciencelab.service;

import com.solvd.sciencelab.dao.ExperimentDao;
import com.solvd.sciencelab.entities.Experiment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExperimentService {

    ExperimentDao experimentDao = new ExperimentDao();

    public Experiment getExperimentById(long id) {
        Experiment ex = new Experiment();
        try {
            ex = experimentDao.select(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ex;
    }

    public List<Experiment> getAllExperiments() {
        List<Experiment> experiments = new ArrayList<>();
        try {
            experiments = experimentDao.selectAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return experiments;
    }

    public List<Experiment> getAllExperimentByTestTubeUsage() throws SQLException {
        return experimentDao.selectAll().stream()
                .sorted(Comparator.comparing(Experiment::getTestTubeUsage))
                .collect(Collectors.toList());
    }

    public void newExperiment(Experiment experiment) {
        experimentDao.insert(experiment);
    }

    public void changeExperimentById(Experiment experiment, int id) {
        experimentDao.update(experiment, id);
    }

    public void cancelExperiment(Experiment experiment) {
        try {
            experimentDao.delete(experiment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
