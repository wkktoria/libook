package io.github.wkktoria.libook;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDbUtil {
    private final DataSource dataSource;

    public StatusDbUtil(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Status getStatus(int id) throws SQLException {
        Status status;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            String sql = "select * from Status where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                status = new Status(id, resultSet.getString("description"));
            } else {
                throw new SQLException("Status not found");
            }

            return status;
        } finally {
            close(connection, statement, resultSet);
        }
    }
}
