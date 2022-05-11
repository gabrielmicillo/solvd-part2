package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.LabSize;
import com.solvd.sciencelab.Laboratory;
import com.solvd.sciencelab.PhoneNumber;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberDao implements Dao<PhoneNumber> {
    @Override
    public PhoneNumber select(long id) {
        String query = "SELECT id, phone_number, lab_id FROM Phone_Numbers WHERE id = " + id;
        PhoneNumber pNumber;
        Laboratory laboratory = new Laboratory();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int phoneNumberId = resultSet.getInt("id");
            int phoneNumber = resultSet.getInt("phone_number");

            pNumber = new PhoneNumber(phoneNumberId, phoneNumber, laboratory);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pNumber;
    }

    @Override
    public List<PhoneNumber> selectAll() {
        String query = "SELECT id, phone_number, lab_id FROM Phone_Numbers";
        PhoneNumber pNumber;
        Laboratory laboratory = new Laboratory();
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int phoneNumberId = resultSet.getInt("id");
                int phoneNumber = resultSet.getInt("phone_number");

                pNumber = new PhoneNumber(phoneNumberId, phoneNumber, laboratory);
                phoneNumbers.add(pNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneNumbers;
    }

    @Override
    public void insert(PhoneNumber phoneNumber) {
        String query = "INSERT INTO Phone_Numbers (phone_number) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, phoneNumber.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PhoneNumber phoneNumber, int id) {
        String query = "UPDATE Phone_Numbers SET phone_number = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, phoneNumber.getPhoneNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(PhoneNumber phoneNumber) {
        String query = "DELETE FROM Phone_Numbers WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, phoneNumber.getPhoneNumberId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
