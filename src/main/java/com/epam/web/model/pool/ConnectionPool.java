package com.epam.web.model.pool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    private final Logger logger = LogManager.getLogger(ConnectionPool.class);

    private static final ConnectionPool instance = new ConnectionPool();
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenConnections;
    private final int DEFAULT_POOL_SIZE = 12;
    private final int FATAL_CONNECTION_ERROR_NUMBER = 8;

    private final String url = "jdbc:mysql://localhost:3306/bookshopdb?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false";
    private final String user = "root";
    private final String password = "Yjdjcnbrbyj141600";

    private ConnectionPool() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            logger.info("database connection established");

            freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
            givenConnections = new ArrayDeque<>(FATAL_CONNECTION_ERROR_NUMBER);

            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.add(proxyConnection);
            }
            logger.info("connections are successfully initialized");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public ProxyConnection getConnection() {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = freeConnections.take();
            givenConnections.offer(proxyConnection);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return proxyConnection;
    }

    public void releaseConnection(Connection connection) {
        if (connection instanceof ProxyConnection && givenConnections.remove(connection)) {
            freeConnections.offer((ProxyConnection) connection);
            logger.info("Connection has been released");
        } else {
            logger.error("Connection release failed");
        }
    }

    public void destroyPool() {
        for(int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().close();
            } catch (InterruptedException | SQLException e) {
                logger.error(e.getMessage());
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        });
    }
}
