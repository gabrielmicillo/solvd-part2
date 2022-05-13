package com.solvd.sciencelab.dao;




import com.solvd.sciencelab.Experiment;
import com.solvd.sciencelab.ExperimentType;
import com.solvd.sciencelab.Financiation;
import com.solvd.sciencelab.Laboratory;
import com.solvd.sciencelab.Status;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExperimentDao implements Dao<Experiment> {
    @Override
    public Experiment select(long id) {
//        String query = "SELECT ex.id, ex.test_tube_usage, ex.status_id, ex.experiment_types_id, ex.financiations_id, ex.lab_id, s.exp_status, et.type_name, et.cost_per_hour, f.fin_origin FROM experiments ex " +
//                "JOIN status s on ex.status_id = s.id " +
//                "JOIN experiment_types et on ex.experiment_types_id = et.id " +
//                "JOIN financiations f on ex.financiations_id = f.id WHERE ex.id = " + id;
//
//        Experiment experiment;
//        Status status = new Status();
//        ExperimentType experimentType = new ExperimentType();
//        Financiation financiation = new Financiation();
//        Laboratory laboratory = new Laboratory();
//
//        try {
//            Connection connection = Conection.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//
//            //Experiment info
//            int experimentId = resultSet.getInt("id");
//            int testTubeUsage = resultSet.getInt("test_tube_usage");
//
//            //Status info
////            status.setStatusId(resultSet.getInt("status_id"));
//            status.setExpStatus(resultSet.getString("exp_status"));
//
//            //Experiment Type info
////            experimentType.setExperimentTypeId(resultSet.getInt("experiment_types_id"));
//            experimentType.setTypeName(resultSet.getString("type_name"));
//            experimentType.setCostPerHour(resultSet.getInt("cost_per_hour"));
//
//            //Financiation info
////            financiation.setFinanciationId(resultSet.getInt("financiations_id"));
//            financiation.setFinOrigin(resultSet.getString("fin_origin"));
//
////            experiment = new Experiment(experimentId, testTubeUsage, status, experimentType, financiation, laboratory);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public List<Experiment> selectAll(){
//        String query = "SELECT ex.id, ex.test_tube_usage, ex.status_id, ex.experiment_types_id, ex.financiations_id, ex.lab_id, s.exp_status, et.type_name, et.cost_per_hour, f.fin_origin FROM experiments ex " +
//                "JOIN status s on ex.status_id = s.id " +
//                "JOIN experiment_types et on ex.experiment_types_id = et.id " +
//                "JOIN financiations f on ex.financiations_id = f.id";
//
//        Experiment experiment;
//        Status status = new Status();
//        ExperimentType experimentType = new ExperimentType();
//        Financiation financiation = new Financiation();
//        Laboratory laboratory = new Laboratory();
//        List<Experiment> experiments = new ArrayList<>();
//
//
//        try {
//            Connection connection = Conection.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//
//                //Experiment info
//                int experimentId = resultSet.getInt("id");
//                int testTubeUsage = resultSet.getInt("test_tube_usage");
//
//                //Status info
//                status.setStatusId(resultSet.getInt("status_id"));
//                status.setExpStatus(resultSet.getString("exp_status"));
//
//                //Experiment Type info
//                experimentType.setExperimentTypeId(resultSet.getInt("experiment_types_id"));
//                experimentType.setTypeName(resultSet.getString("type_name"));
//                experimentType.setCostPerHour(resultSet.getInt("cost_per_hour"));
//
//                //Financiation info
//                financiation.setFinanciationId(resultSet.getInt("financiations_id"));
//                financiation.setFinOrigin(resultSet.getString("fin_origin"));
//
//                experiment = new Experiment(experimentId, testTubeUsage, status, experimentType, financiation, laboratory);
//                experiments.add(experiment);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public void insert(Experiment experiment) {
        String query = "INSERT INTO experiments (test_tube_usage) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experiment.getTestTubeUsage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Experiment experiment, int id) {
        String query = "UPDATE experiments SET test_tube_usage = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experiment.getTestTubeUsage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Experiment experiment) {
        String query = "DELETE FROM experiments WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experiment.getTestTubeUsage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
