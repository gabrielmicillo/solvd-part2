package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.*;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import com.solvd.sciencelab.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MyBatisRunner {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);

    private static SqlSessionFactory factory = SqlSessionFactoryUtil.getInstance();

    public static void main(String[] args) throws SQLException {
        try (SqlSession session = factory.openSession()) {
            IClientDao clientMapper = session.getMapper(IClientDao.class);
            LOGGER.info("------CLIENTS------");
            Client client = clientMapper.select(1);
            LOGGER.info("Client = " + client);
            LOGGER.info(client.getClientId());
            LOGGER.info("Client = " + clientMapper.select(2));
            clientMapper.insert("Rodrigo", "De Paul");
            clientMapper.update("Braian", "Sarmiento", 4);
            List<Client> clientList = clientMapper.selectAll();
            LOGGER.info(clientList);

            ILabSizeDao labSizeMapper = session.getMapper(ILabSizeDao.class);
            LOGGER.info("------LABORATORY SIZES------");
            LabSize labSize = labSizeMapper.select(1);
            labSize = labSizeMapper.selectByName("Medium");
            LOGGER.info(labSize);
            LOGGER.info(labSize.getLabSizeId());
            LOGGER.info("Laboratory size = " + labSize);
            LOGGER.info("Laboratory Size = " + labSizeMapper.select(2));
            labSizeMapper.insert("Very little", 489);
            labSizeMapper.update("Average size", 600, 2);
            List<LabSize> labSizeList = labSizeMapper.selectAll();
            LOGGER.info(labSizeList);

            ICityDao cityMapper = session.getMapper(ICityDao.class);
            LOGGER.info("------CITIES------");
            City city = cityMapper.select(1);
            LOGGER.info("City = " + city);
            LOGGER.info(city.getCityId());
            city = cityMapper.selectByName("Chicago");
            LOGGER.info(city);
            LOGGER.info(city.getCityId());
            LOGGER.info("City = " + cityMapper.select(2));
            cityMapper.insert("Managua");
            cityMapper.update("Guayaquil", 2);
            List<City> cities = cityMapper.selectAll();
            LOGGER.info(cities);

//            Reading existing laboratory
            ILaboratoryDao laboratoryMapper = session.getMapper(ILaboratoryDao.class);
            LOGGER.info("------LABORATORIES------");
            Laboratory laboratory = laboratoryMapper.select(1);
            laboratory.setCity(cityMapper.select(laboratory.getCityId()));
            laboratory.setLabsize(labSizeMapper.select(laboratory.getLabSizeId()));
            LOGGER.info(laboratory);

//            Populating and inserting laboratory
            labSizeMapper.insert("Maximum size", 3000);
            labSize = labSizeMapper.selectByName("Maximum size");
            cityMapper.insert("Coritiba");
            city = cityMapper.selectByName("Coritiba");
            laboratoryMapper.insert("WorldLab", 480, labSize.getLabSizeId(), city.getCityId());
            Laboratory lab = laboratoryMapper.selectByName("WorldLab");
            lab.setLabsize(labSizeMapper.select(lab.getLabSizeId()));
            lab.setCity(cityMapper.select(lab.getCityId()));
            LOGGER.info(lab);

        }
    }
}
