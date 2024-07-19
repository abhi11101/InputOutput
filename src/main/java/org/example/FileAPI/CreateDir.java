package org.example.FileAPI;

import java.io.File;
import java.io.IOException;

public class CreateDir {

    public static void main(String[] args) {

        // Making Directory
        File dir = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments");
        dir.mkdir();

        // Adding file to the directory
        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\MyDocuments.txt");
        try {

            file.createNewFile();
        }catch (IOException e) {
            e.printStackTrace();
        }

        // Display Directory Contents
        String[] list = dir.list();
        for(String str : list) {
            System.out.println(str);
        }
        System.out.println("-".repeat(40));

        //Adding subdirectory
        File subDir = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff");
        subDir.mkdir();

        // To show only directories
        String[] content = dir.list();
        for (String str : content){
            if (new File(dir, str).isDirectory()){ // new File is converting the str value to file object
                System.out.println(str);
            }
        }
    }

}
