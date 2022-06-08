package com.solvd.sciencelab.designpatterns;

import com.solvd.sciencelab.dao.*;
import com.solvd.sciencelab.entities.*;
import com.solvd.sciencelab.service.LaboratoryService;

public class JDBCFactory extends AbstractFactory {
    public static IDao<?> chooseDao(String dao) {
        dao = dao.toLowerCase();
        switch (dao) {
            case "city":
                IDao<City> cityDao = new CityDao();
                return cityDao;
            case "client":
                IDao<Client> clientDao = new ClientDao();
                return clientDao;
            case "experimenttype":
                IDao<ExperimentType> experimentTypeDao = new ExperimentTypeDao();
                return experimentTypeDao;
            case "laboratory":
                IDao<Laboratory> laboratoryDao = new LaboratoryDao();
                return laboratoryDao;
            case "labsize":
                IDao<LabSize> labSizeDao = new LabSizeDao();
                return labSizeDao;
            case "status":
                IDao<Status> statusDao = new StatusDao();
                return statusDao;
        }
        return null;
    }
}
