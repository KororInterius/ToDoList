package com.koror.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    public static String JDBC_DRIVER;

    public static String URL;

    public static String USER;

    public static String PASSWORD;

    public static String HIBERNATE_DIALECT;

    public static String HBM2DDL_AUTO;

    public static String HIBERNATE_SHOW_SQL;

    public static String PREFIXDB;

    public static void init() throws IOException{
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream(AppConfig.class.getClassLoader().getResource("config.properties").getPath());
        property.load(fis);
        JDBC_DRIVER = property.getProperty("db.driver");
        URL = property.getProperty("db.url");
        USER = property.getProperty("db.user");
        PASSWORD = property.getProperty("db.password");
        HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
        HBM2DDL_AUTO = "create-drop";
        HIBERNATE_SHOW_SQL = "true";
        PREFIXDB = "tm_";
    }

}