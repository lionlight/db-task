module com.example.dbtasktest {
    requires lombok;
    requires java.sql;
    requires java.desktop;

    exports com.finplatforms.test.dbtasktest;
    exports com.finplatforms.test.dbtasktest.ui;
    exports com.finplatforms.test.dbtasktest.db.dao;
}