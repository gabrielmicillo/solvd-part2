package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.ExperimentType;
import com.solvd.sciencelab.Financiation;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinanciationDao implements Dao<Financiation> {
    @Override
    public Financiation select(long id) {
        String query = "SELECT id, fin_origin FROM Financiations WHERE id = " + id;
        Financiation financiation;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int financiationId = resultSet.getInt("id");
            String finOrigin = resultSet.getString("fin_origin");

            financiation = new Financiation(financiationId, finOrigin);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return financiation;
    }

    @Override
    public List<Financiation> selectAll() {
        String query = "SELECT id, fin_origin FROM Financiations";
        Financiation financiation;
        List<Financiation> financiations = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int financiationId = resultSet.getInt("id");
                String finOrigin = resultSet.getString("fin_origin");

                financiation = new Financiation(financiationId, finOrigin);
                financiations.add(financiation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return financiations;
    }

    @Override
    public void insert(Financiation financiation) {
        String query = "INSERT INTO financiations (fin_origin) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, financiation.getFinOrigin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Financiation financiation, int id) {
        String query = "UPDATE financiations SET fin_origin = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, financiation.getFinOrigin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Financiation financiation) {
        String query = "DELETE FROM financiations WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, financiation.getFinanciationId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
