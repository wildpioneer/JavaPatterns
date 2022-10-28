package org.wp.javapatterns.utils;

import java.io.IOException;
import java.util.Properties;

public final class ReadPropertiesSingleton {
    private static ReadPropertiesSingleton instance;
    private static Properties properties = null;

    private ReadPropertiesSingleton() {
        properties = new Properties();
        try {
            properties.load(ReadPropertiesSingleton.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadPropertiesSingleton getInstance() {
        if (instance == null) {
            instance = new ReadPropertiesSingleton();
        }
        return instance;
    }

    public static String getUrl() {
        return getInstance().properties.getProperty("url");
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
