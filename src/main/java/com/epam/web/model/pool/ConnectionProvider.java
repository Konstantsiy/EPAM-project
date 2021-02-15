//package com.epam.web.model.pool;
//
//import java.io.InputStream;
//import java.sql.*;
//
//public class ConnectionProvider {
//    private Connection connection;
//    private PreparedStatement statement;
//    private ResultSet resultSet;
//
//    public ConnectionProvider(Connection connection) {
//        this.connection = connection;
//        this.resultSet = null;
//    }
//
//    public void init(String SQLRequest) throws SQLException {
//        statement = connection.prepareStatement(SQLRequest);
//    }
//
//    private void fillStatement(Object[] list) throws SQLException {
//        for(int i = 0; i < list.length; i++) {
//            if(list[i] instanceof Integer) {
//                this.statement.setInt(i + 1, (Integer) list[i]);
//            } else if(list[i] instanceof String) {
//                this.statement.setString(i + 1, String.valueOf(list[i]));
//            } else if(list[i] instanceof InputStream) {
//                this.statement.setBlob(i + 1, (InputStream) list[i]);
//            }
//        }
//    }
//
//    public ResultSet executeQuery(Object[] args) throws SQLException {
//        fillStatement(args);
//        return statement.executeQuery();
//    }
//
//    public int executeUpdate(Object[] args) throws SQLException {
//        fillStatement(args);
//        return statement.executeUpdate();
//    }
//}
