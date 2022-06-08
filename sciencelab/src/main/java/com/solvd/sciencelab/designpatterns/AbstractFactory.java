package com.solvd.sciencelab.designpatterns;

public class AbstractFactory {
    private static final JDBCFactory jdbcFactory = new JDBCFactory();
    private static final MyBatisFactory myBatisFactory = new MyBatisFactory();

    public static AbstractFactory chooseFactory(String connection) {
        connection = connection.toLowerCase();
        switch (connection) {
            case "jdbc":
                return jdbcFactory;
            case "mybatis":
                return myBatisFactory;
        }
        return null;
    }
}
