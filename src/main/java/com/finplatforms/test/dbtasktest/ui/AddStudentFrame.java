package com.finplatforms.test.dbtasktest.ui;

import com.finplatforms.test.dbtasktest.db.MessageBDEventManager;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class AddStudentFrame extends AbstractStudentFrame {

    @Getter
    private static JTextField firstName;
    @Getter
    private static JTextField lastName;
    @Getter
    private static JTextField middleName;
    @Getter
    private static JTextField birthday;
    @Getter
    private static JTextField groupName;
    @Getter
    private static JCheckBox check;
    private static final JPanel panel = new JPanel();

    public AddStudentFrame() {
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setResizable(false);
        super.setBounds(100, 100, 500, 200);
        super.setTitle("Добавить студента");

        panel.setLayout(new GridLayout(3, 2, 2, 2));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<JComponent> listJComponents = new ArrayList<>();

        JLabel firstNameLabel = new JLabel("Введите имя: ");
        JLabel lastNameLabel = new JLabel("Введите фамилию: ");
        JLabel middleNameLabel = new JLabel("Введите отчество: ");
        JLabel birthdayLabel = new JLabel("Введите дату рождения: ");
        JLabel groupNameLabel = new JLabel("Введите название группы: ");

        firstName = new JTextField("", 1);
        lastName = new JTextField("", 1);
        middleName = new JTextField("", 1);
        birthday = new JTextField("", 1);
        groupName = new JTextField("", 1);

        listJComponents.add(firstNameLabel);
        listJComponents.add(firstName);
        listJComponents.add(lastNameLabel);
        listJComponents.add(lastName);
        listJComponents.add(middleNameLabel);
        listJComponents.add(middleName);
        listJComponents.add(birthdayLabel);
        listJComponents.add(birthday);
        listJComponents.add(groupNameLabel);
        listJComponents.add(groupName);

        for (JComponent component : listJComponents) {
            panel.add(component);
        }

        check = new JCheckBox("Подтверждаю действие", false);

        JButton send_button = new JButton("Отправить");

        send_button.addActionListener((event) ->
                MessageBDEventManager.addStudentMessage());

        panel.add(check);
        panel.add(send_button);
        super.add(panel);
    }
}
