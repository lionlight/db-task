package com.finplatforms.test.dbtasktest.db.dao;

import lombok.Getter;

class Queries {
    @Getter
    private static final String SQL_CREATE_STUDENT_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS student (\n" +
            "\tstudent_id serial PRIMARY KEY,\n" +
            "\tfirst_name VARCHAR ( 255 ) NOT NULL,\n" +
            "\tlast_name VARCHAR ( 255 ) NOT NULL,\n" +
            "\tmiddle_name VARCHAR ( 255 ) NOT NULL,\n" +
            "\tbirthday DATE NOT NULL,\n" +
            "\tgroup_name VARCHAR ( 50 ) NOT NULL\n" +
            ");";

    @Getter
    private static final String SQL_GET_ALL_STUDENTS = "SELECT * from student;";

    @Getter
    public static String SQL_DELETE_STUDENT = "DELETE FROM student WHERE student_id = ?";

    @Getter
    public static String SQL_ADD_STUDENT = "INSERT INTO student (last_name, first_name, middle_name, birthday, group_name) VALUES (?,?,?,?,?);";
}
