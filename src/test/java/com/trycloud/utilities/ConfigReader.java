package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A Utility class that load the keyvalue pair inside config.properties file
 * into Properties object and provide single method called
 * read to get the value out of the properties file we created.
 */
public class ConfigReader {

    private static Properties configFile;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
