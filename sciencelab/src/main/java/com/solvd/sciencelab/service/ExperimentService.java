package com.solvd.sciencelab.service;

import com.solvd.sciencelab.Employee;
import com.solvd.sciencelab.Experiment;
import com.solvd.sciencelab.Order;
import com.solvd.sciencelab.dao.ExperimentDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExperimentService {

    ExperimentDao experimentDao = new ExperimentDao();

    public Experiment getExperimentById(int id) {
        return experimentDao.select(id);
    }

    public List<Experiment> getAllExperiment() {
        return experimentDao.selectAll();
    }

    public List<Experiment> getAllExperimentByTestTubeUsage() {
        return experimentDao.selectAll().stream()
                .sorted(Comparator.comparing(Experiment::getTestTubeUsage))
                .collect(Collectors.toList());
    }

    public void newExperiment (Experiment experiment) {
        experimentDao.insert(experiment);
    }

    public void changeExperimentById(Experiment experiment, int id) {
        experimentDao.update(experiment, id);
    }

    public void cancelExperiment (Experiment experiment) {
        experimentDao.delete(experiment);
    }
}
