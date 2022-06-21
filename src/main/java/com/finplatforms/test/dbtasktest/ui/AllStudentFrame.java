package com.finplatforms.test.dbtasktest.ui;

import com.finplatforms.test.dbtasktest.db.dao.StudentDAO;
import com.finplatforms.test.dbtasktest.db.dto.StudentDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllStudentFrame extends AbstractStudentFrame {

    public AllStudentFrame() {
        defaultFrameInitialize("Список студентов");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(false);
        super.setLayout(new BorderLayout());

        Object[] columnNames = {"Уникальный номер", "Фамилия", "Имя", "Отчество", "Дата рождения", "Группа"};

        List<StudentDTO> studentDTOList = new ArrayList<>();

        int count = 0;

        try {
            ResultSet resultSet = StudentDAO.getAllStudents();
            if (resultSet != null) {
                while (resultSet.next()) {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(resultSet.getInt("student_id"));
                    studentDTO.setLastName(resultSet.getString("last_name"));
                    studentDTO.setFirstName(resultSet.getString("first_name"));
                    studentDTO.setMiddleName(resultSet.getString("middle_name"));
                    studentDTO.setBirthday(Date.valueOf(resultSet.getString("birthday")));
                    studentDTO.setGroupName(resultSet.getString("group_name"));
                    studentDTOList.add(studentDTO);
                    ++count;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Object[][] data = new Object[count][count * 5 + 1];

        for (int i = 0; i < studentDTOList.size(); i++) {
            data[i][0] = studentDTOList.get(i).getId();
            data[i][1] = studentDTOList.get(i).getFirstName();
            data[i][2] = studentDTOList.get(i).getLastName();
            data[i][3] = studentDTOList.get(i).getMiddleName();
            data[i][4] = studentDTOList.get(i).getBirthday();
            data[i][5] = studentDTOList.get(i).getGroupName();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(450, 63));
        table.setFillsViewportHeight(true);

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setVisible(true);
        super.add(jScrollPane);
    }
}
