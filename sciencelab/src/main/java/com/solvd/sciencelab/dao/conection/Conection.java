package com.solvd.sciencelab.dao.conection;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Conection {

    public static DataSource getDataSource() {

        Properties props = new Properties();

        try {
            FileReader reader = new FileReader("src/main/resources/db.properties");
            props.load(reader);
        } catch (IOException e) {
            e.getMessage();
        }

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(10);
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}