package com.finplatforms.test.dbtasktest.db;

import com.finplatforms.test.dbtasktest.db.dao.StudentDAO;
import com.finplatforms.test.dbtasktest.db.dto.StudentDTO;
import com.finplatforms.test.dbtasktest.ui.AddStudentFrame;
import com.finplatforms.test.dbtasktest.ui.DeleteStudentFrame;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MessageBDEventManager implements ActionListener {
    @SneakyThrows
    public static void deleteStudentMessage(String id) {
        int count = StudentDAO.deleteStudent(Integer.parseInt(id));

        JOptionPane.showMessageDialog(null,
                "Студент: \n" +
                        "ID: " + DeleteStudentFrame.getId().getText() + "\n",
                "Всего " + count + " студент удалён",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void addStudentMessage() {

        StudentDTO studentDTO = new StudentDTO();

        try {
            studentDTO.setFirstName(AddStudentFrame.getFirstName().getText());
            studentDTO.setLastName(AddStudentFrame.getLastName().getText());
            studentDTO.setMiddleName(AddStudentFrame.getMiddleName().getText());
            studentDTO.setBirthday(Date.valueOf(AddStudentFrame.getBirthday().getText()));
            studentDTO.setGroupName(AddStudentFrame.getGroupName().getText());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        if (AddStudentFrame.getCheck().isSelected() && AddStudentFrame.getFirstName().isEnabled()) {

            int count = StudentDAO.addStudent(studentDTO);

            JOptionPane.showMessageDialog(null,
                    "Студент: \n" +
                            "Фамилия: " + studentDTO.getLastName() + "\n" +
                            "Имя: " + studentDTO.getFirstName() + "\n" +
                            "Отчество: " + studentDTO.getMiddleName() + "\n" +
                            "Дата рождения: " + studentDTO.getBirthday() + "\n" +
                            "Группа: " + studentDTO.getGroupName(),
                    "всего" + count + "студент успешно добавлен в базу данных",
                    JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Студент не добавлен в базу данных, вы не подтвердили свои действия",
                    "",
                    JOptionPane.PLAIN_MESSAGE);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
