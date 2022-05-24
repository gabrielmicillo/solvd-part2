package com.solvd.sciencelab.service;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.dao.LaboratoryDao;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class LaboratoryService extends JDBCDao {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryService.class);
    private final ConnectionPool cp = getCp();

    LaboratoryDao laboratoryDao = new LaboratoryDao();


    public List<Laboratory> getAllLabsByExpCapacity() throws SQLException {
        return laboratoryDao.selectAll().stream()
                .sorted(Comparator.comparing(Laboratory::getExpCapacity))
                .collect(Collectors.toList());
    }

}
