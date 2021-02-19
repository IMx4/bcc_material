package com.bcc.mm.service;

import com.bcc.mm.dto.EmployeeDTO;
import com.bcc.mm.dto.ProductDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {



    public static void logUpdateItem(ProductDTO product, EmployeeDTO employee, int qty){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {
            FileWriter fw = new FileWriter("./logs.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            String employeeName = "[ " + employee.getFirstName() + " " + employee.getLastName() + " ] ";
            String productName = product.getDescription();

            bw.write(employeeName + productName + " << " + qty + " >> " + " ( " + now + " )");
            bw.newLine();
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }





    }




}
