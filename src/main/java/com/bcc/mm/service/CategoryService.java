package com.bcc.mm.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CategoryService {

    Properties property;
    List<String> categories;

    public CategoryService(){

        loadCategories();
    }


    private void loadCategories(){

        property = new Properties();

        try {
            property.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }

        categories = Arrays.asList(property.getProperty("categories").split(","));


    }

    public List<String> getCategories(){
        return categories;
    }


}












