package com.finplatforms.test.dbtasktest.ui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static com.finplatforms.test.dbtasktest.db.MessageBDEventManager.deleteStudentMessage;

public class DeleteStudentFrame extends AbstractStudentFrame {

    @Getter
    private static JTextField id;

    public DeleteStudentFrame() {

        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setBounds(100, 100, 500, 200);

        defaultFrameInitialize("Удалить студента");
        JPanel panel = new JPanel();

        JPanel inputPanel = new JPanel();
        JButton button = new JButton("Отправить");

        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);

        inputPanel.setLayout(new FlowLayout());

        id = new JTextField(20);

        inputPanel.add(id);
        inputPanel.add(button);

        button.addActionListener((event) ->
                deleteStudentMessage(id.getText()));

        panel.add(inputPanel);

        super.getContentPane().add(BorderLayout.CENTER, panel);
        super.add(panel);
        id.requestFocus();
    }
}
