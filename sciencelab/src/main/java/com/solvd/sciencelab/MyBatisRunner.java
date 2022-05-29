package com.solvd.sciencelab;

import com.solvd.sciencelab.dao.ClientDao;
import com.solvd.sciencelab.dao.Dao;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.util.SqlSessionFactoryUtil;
import org.apache.ibatis.annotations.Mapper;
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
            Dao clientMapper = session.getMapper(Dao.class);
            Client client = (Client) clientMapper.select(1);
            LOGGER.info("Client = " + client);
//            clientMapper.insert("Avianca LFH 25514", 122);
//            planeMapper.update("Boeing LFH 25514", 428, 2);
            LOGGER.info("Client = " + clientMapper.select(2));
            List<Client> clientList = clientMapper.selectAll();
            LOGGER.info(clientList);
        }
    }
}
