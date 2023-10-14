package org.scorp.core.database;

import org.scorp.core.exception.GeneralException;

public class PostgresQuery {

    private PostgresQuery() {
        throw new GeneralException("PostgresQuery Instance Error");
    }

    public static final String SELECT = "SELECT * FROM %s";
    public static final String WHERE = "WHERE";
    public static final String IN = "IN (%s)";
    public static final String IN_QUERY = SELECT + " " + WHERE  + " %s " + IN;
}
