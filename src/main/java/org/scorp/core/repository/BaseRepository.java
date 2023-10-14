package org.scorp.core.repository;

import org.scorp.core.database.connector.PostgresSqlConnector;

import java.util.List;

public class BaseRepository<T, ID> {
    protected final PostgresSqlConnector postgresSqlConnector = PostgresSqlConnector.getInstance();

    protected List<T> findAllByIds(List<ID> postIds) {
        throw new UnsupportedOperationException();
    }

    protected T findById(ID id) {
        throw new UnsupportedOperationException();
    }
}
