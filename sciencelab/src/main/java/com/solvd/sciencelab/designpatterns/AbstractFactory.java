package com.solvd.sciencelab.designpatterns;

import java.util.Locale;

public class AbstractFactory {
    private static JDBCFactory jdbcFactory = new JDBCFactory();
    private static MyBatisFactory myBatisFactory = new MyBatisFactory();

    public static AbstractFactory chooseFactory(String connection) {
        connection = connection.toLowerCase();
        switch (connection) {
            case "jdbc": return jdbcFactory;
            case "mybatis": return myBatisFactory;
        }
        return null;
    }
}
