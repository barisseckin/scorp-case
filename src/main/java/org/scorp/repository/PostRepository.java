package org.scorp.repository;

import org.scorp.core.database.PostgresQuery;
import org.scorp.entity.Post;
import org.scorp.core.exception.GeneralException;
import org.scorp.core.repository.BaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository extends BaseRepository<Post, Long> {

    @Override
    public List<Post> findAllByIds(List<Long> postIds) {
        String stringPostIds = postIds.stream().map(Object::toString).collect(Collectors.joining(", "));
        String query = String.format(PostgresQuery.IN_QUERY, "post", "id", stringPostIds);

        Connection connection = postgresSqlConnector.getConnection();
        Statement statement;
        try {
            List<Post> posts = new ArrayList<>();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Post post = new Post(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getBoolean(6)
                );

                posts.add(post);
            }

            return posts;

        } catch (SQLException e) {
            throw new GeneralException(e.getMessage());
        }
    }
}
