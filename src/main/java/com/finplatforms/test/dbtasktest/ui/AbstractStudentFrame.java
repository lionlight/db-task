package com.finplatforms.test.dbtasktest.ui;

import javax.swing.*;

public abstract class AbstractStudentFrame extends JFrame{
    void defaultFrameInitialize(String title) {
        super.setBounds(100, 100, 500, 400);
        super.setTitle(title);
    }
}
