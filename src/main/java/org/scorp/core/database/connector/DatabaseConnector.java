package org.scorp.core.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    protected Connection connection;

    public DatabaseConnector(String jdbcUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    public Connection getConnection() {
        return connection;
    }

}
