package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ServerProperties {
    private static final String FILE_NAME = "server.properties";
    private Properties properties;

    public ServerProperties() throws IOException {
        properties = new Properties();
        FileInputStream inputStream = new FileInputStream(FILE_NAME);
        properties.load(inputStream);
        inputStream.close();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        properties.store(outputStream, "Modified by ServerProperties");
        outputStream.close();
    }
}
