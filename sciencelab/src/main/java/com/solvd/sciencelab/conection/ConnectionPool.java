package com.solvd.sciencelab.conection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final Properties props = new Properties();
    private static final int INITIAL_POOL_SIZE = 1;
    private static List<Connection> connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
    private static ConnectionPool INSTANCE = null;

    static {
        try {
            FileReader reader = new FileReader("src/main/resources/db.properties");
            props.load(reader);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private String url = props.getProperty("url");
    private String user = props.getProperty("user");
    private String password = props.getProperty("password");
    private final List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
    }

    private ConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        ConnectionPool.connectionPool = pool;
    }

    public static ConnectionPool getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = ConnectionPool.create(props.getProperty("url"), props.getProperty("user"),
                    props.getProperty("password"));
        }
        return INSTANCE;
    }

    private static ConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new ConnectionPool(url, user, password, pool);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public void closeAllConnections(ConnectionPool cp) {
        cp.getConnectionPool().forEach((conn) -> {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Connection> getConnectionPool() {
        return connectionPool;
    }
}
