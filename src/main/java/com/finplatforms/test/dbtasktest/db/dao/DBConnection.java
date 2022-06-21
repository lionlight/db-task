package com.finplatforms.test.dbtasktest.db.dao;

import lombok.Getter;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());

    private static Connection connection;

    @NonNull
    public static Connection getConnection() {
        DBConnectionUtil.initialConnectionFromEnv();

        try {
            connection = DriverManager.getConnection(
                    DBConnectionUtil.getDB_URL(), DBConnectionUtil.getDB_USERNAME(), DBConnectionUtil.getDB_PASSWORD());

            Statement statement = connection.createStatement();

            statement.execute(Queries.getSQL_CREATE_STUDENT_TABLE_QUERY());

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "DB Connection error", e);
        }

        return Objects.requireNonNull(connection);
    }

}





































