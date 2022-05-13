package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.LabSizeDao;
import com.solvd.sciencelab.service.LabSizeService;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        LabSizeService labSizeService = new LabSizeService();
        System.out.println(labSizeService.getLabSizeById(1));

        LabSizeDao labSizeDao = new LabSizeDao();
        System.out.println(labSizeDao.selectAll());

    }
}
