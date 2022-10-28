package org.wp.javapatterns.utils;

import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getBrowserName() {
        return properties.getProperty("browser");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

}
