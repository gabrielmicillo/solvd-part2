package com.solvd.sciencelab;

import com.solvd.sciencelab.designpatterns.ExperimentBuilder;
import com.solvd.sciencelab.entities.Experiment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DesignPatternsRunner {
    private static final Logger LOGGER = LogManager.getLogger(DesignPatternsRunner.class);

    public static void main(String[] args) {

//        Suppose we just want to create a very simple experiment object
        Experiment simpleExperiment = new ExperimentBuilder().setTestTubeUsage(85).build();
        LOGGER.info(simpleExperiment);
    }
}
