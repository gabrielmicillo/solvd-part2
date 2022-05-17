package com.solvd.sciencelab.conection;

import java.sql.SQLException;

public abstract class JDBCDao {
    private static ConnectionPool cp;

    static {
        try {
            cp = ConnectionPool.getInstance();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static ConnectionPool getCp() {
        return cp;
    }

    public static void setCp(ConnectionPool Cp) {
        cp = Cp;
    }
}
