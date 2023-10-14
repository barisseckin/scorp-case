package org.scorp.core.database;

import org.scorp.core.exception.GeneralException;

public class PostgresSqlConnectionInformation{

    private PostgresSqlConnectionInformation() {
        throw new GeneralException("PostgresSqlConnectionInformation Instance Error");
    }

    public static final String URI = "jdbc:postgresql://localhost:5432/scorp";
    public static final String USER = "postgres";
    public static final String PASSWD = "postgres";
}
