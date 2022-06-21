package com.finplatforms.test.dbtasktest;

import com.finplatforms.test.dbtasktest.db.dao.DBConnection;
import com.finplatforms.test.dbtasktest.ui.MainFrame;

public class HelloApplication {

    public static void main(String[] args) {
        MainFrame form = new MainFrame();
        form.setVisible(true);
        DBConnection.getConnection();
    }
}