package com.solvd.sciencelab.conection;

import java.sql.SQLException;

public abstract class JDBCDao {
    private static ConnectionPool connPool;

    static {
        try {
            connPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static ConnectionPool getCp() {
        return connPool;
    }

    public static void setCp(ConnectionPool ConnPool) {
        connPool = ConnPool;
    }
}
