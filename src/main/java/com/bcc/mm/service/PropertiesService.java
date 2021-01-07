package com.bcc.mm.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesService {

    static Properties properties;


    public PropertiesService(){

        loadProperties();
    }


    static void loadProperties(){

        properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }

    }

    public static String isSetup(){

        return properties.getProperty("setup");
    }

    public static void setupComplete(){

        properties.setProperty("setup", "false");
        try {
            properties.store(new FileOutputStream("src/main/resources/application.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> getCategories(){

        return Arrays.asList(properties.getProperty("categories").split(","));
    }

}












