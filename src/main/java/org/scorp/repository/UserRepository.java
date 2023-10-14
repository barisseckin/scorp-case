package org.scorp.repository;

import org.scorp.core.database.PostgresQuery;
import org.scorp.entity.User;
import org.scorp.core.exception.GeneralException;
import org.scorp.core.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository extends BaseRepository<User, Long> {

    @Override
    public User findById(Long id) {
        String query = String.format(PostgresQuery.SELECT + " " + PostgresQuery.WHERE  , "users")
                .concat(" id = " + id.toString());

        Connection connection = postgresSqlConnector.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                return new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5)
                );
            }
        } catch (SQLException e) {
            throw new GeneralException(e.getMessage());
        }
        return null;
    }
}
