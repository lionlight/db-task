package com.finplatforms.test.dbtasktest.db.dao;

import lombok.Getter;

class DBConnectionUtil {
    @Getter
    private static String DB_USERNAME;
    @Getter
    private static String DB_PASSWORD;
    @Getter
    private static String DB_URL;

    public static void initialConnectionFromEnv() {
        DB_USERNAME = System.getenv("DB_USERNAME");
        DB_PASSWORD = System.getenv("DB_PASSWORD");
        DB_URL = System.getenv("DB_URL");
    }
}



































