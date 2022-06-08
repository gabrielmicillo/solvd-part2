package com.solvd.sciencelab.designpatterns;

import com.solvd.sciencelab.dao.*;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import com.solvd.sciencelab.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisFactory extends AbstractFactory {
    private static SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getInstance();
    private static SqlSession sqlSession = sessionFactory.openSession();

    public IDao<?> chooseMapper(String mapper) {
        mapper = mapper.toLowerCase();
        switch (mapper) {
            case "city":
                IDao<City> cityMapper = sqlSession.getMapper(ICityDao.class);
                return cityMapper;
            case "client":
                IDao<Client> clientMapper = sqlSession.getMapper(IClientDao.class);
                return clientMapper;
            case "laboratory":
                IDao<Laboratory> laboratoryMapper = sqlSession.getMapper(ILaboratoryDao.class);
                return laboratoryMapper;
            case "labsize":
                IDao<LabSize> labSizeMapper = sqlSession.getMapper(ILabSizeDao.class);
                return labSizeMapper;
        }
        return null;
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        MyBatisFactory.sqlSession = sqlSession;
    }

}
