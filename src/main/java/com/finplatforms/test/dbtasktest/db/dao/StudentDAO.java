package com.finplatforms.test.dbtasktest.db.dao;

import com.finplatforms.test.dbtasktest.db.dto.StudentDTO;
import lombok.SneakyThrows;

import java.sql.*;

public class StudentDAO {

    static Connection connection = DBConnection.getConnection();

    public static ResultSet getAllStudents() throws SQLException {
        Statement statement;
        if (connection != null) {
            statement = connection.createStatement();
            statement.execute(Queries.getSQL_GET_ALL_STUDENTS());
            return statement.getResultSet();
        }
        return null;
    }

    public static int deleteStudent(int id) throws SQLException {
        PreparedStatement statement;
        if (connection != null) {
            statement = connection.prepareStatement(Queries.getSQL_DELETE_STUDENT());
            statement.setInt(1, id);
            statement.executeUpdate();
            return statement.getUpdateCount();
        }
        return 0;
    }

    @SneakyThrows
    public static int addStudent(StudentDTO studentDTO) {
        PreparedStatement statement;
        if (studentDTO.validateLength() && connection != null) {
            statement = connection.prepareStatement(Queries.getSQL_ADD_STUDENT());
            statement.setString(1, studentDTO.getFirstName());
            statement.setString(2, studentDTO.getLastName());
            statement.setString(3, studentDTO.getMiddleName());
            statement.setDate(4, studentDTO.getBirthday());
            statement.setString(5, studentDTO.getGroupName());
            statement.executeUpdate();
            return statement.getUpdateCount();
        }
        return 0;
    }
}
