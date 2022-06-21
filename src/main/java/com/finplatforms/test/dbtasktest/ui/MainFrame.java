package com.finplatforms.test.dbtasktest.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends AbstractStudentFrame {

    private static final AddStudentFrame addStudentFrame = new AddStudentFrame();

    public MainFrame() {

        defaultFrameInitialize("Приложение");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        JButton showAllStudentsButton = new JButton("Показать всех студентов");
        container.add(showAllStudentsButton);
        showAllStudentsButton.addActionListener(new AllStudentEventManager());

        JButton addStudentButton = new JButton("Добавить студента");
        container.add(addStudentButton);
        addStudentButton.addActionListener(new AddStudentEventManager());

        JButton deleteStudentButton = new JButton("Удалить студента");
        container.add(deleteStudentButton);
        deleteStudentButton.addActionListener(new DeleteStudentEventManager());

    }

    public static class AddStudentEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addStudentFrame.setVisible(true);
            addStudentFrame.setResizable(true);
        }
    }

    public static class AllStudentEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AllStudentFrame allStudentFrame = new AllStudentFrame();
            allStudentFrame.setVisible(true);
            allStudentFrame.setResizable(true);
        }
    }

    public static class DeleteStudentEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteStudentFrame deleteStudentFrame = new DeleteStudentFrame();
            deleteStudentFrame.setVisible(true);
            deleteStudentFrame.setResizable(true);
        }

    }
}



