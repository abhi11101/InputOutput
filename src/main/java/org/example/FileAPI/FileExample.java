package org.example.FileAPI;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\FileAPI.txt");
        System.out.println(file.exists());

        try {

            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(file.exists());
    }
}