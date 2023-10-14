package org.scorp.core.database.connector;


import org.scorp.core.database.PostgresSqlConnectionInformation;
import org.scorp.core.exception.GeneralException;

import java.sql.SQLException;

public class PostgresSqlConnector extends DatabaseConnector {

    private static volatile PostgresSqlConnector postgresSqlConnector;

    private PostgresSqlConnector() throws SQLException {
        super(PostgresSqlConnectionInformation.URI, PostgresSqlConnectionInformation.USER,
                PostgresSqlConnectionInformation.PASSWD);
    }

    public static PostgresSqlConnector getInstance() {
        if (postgresSqlConnector == null) {
            synchronized (PostgresSqlConnector.class) {
                if (postgresSqlConnector == null) {
                    try {
                        postgresSqlConnector = new PostgresSqlConnector();
                    } catch (SQLException e) {
                        throw new GeneralException(e.getMessage());
                    }
                }
            }
        }
        return postgresSqlConnector;
    }

}
