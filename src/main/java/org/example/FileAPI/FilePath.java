package org.example.FileAPI;

import java.io.File;
import java.io.IOException;

public class FilePath {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\MyDocuments.txt");

        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());


        File dir = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments");
        File dir2 = new File(dir,"WorkDocuments");
        dir2.mkdir();

        System.out.println(dir.getParent());
        System.out.println(dir2.getParent());
    }
}
