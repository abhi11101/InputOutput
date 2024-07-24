package org.example.PathAPI;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass {


    public static void main(String[] args) {

        Path path = Paths.get("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\Goku.txt");
        Path path2 = Paths.get("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\DataFile.txt");

        System.out.println(path.getFileName());
        System.out.println(path2.getParent());

        Path path3 = Path.of("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\MyFile.txt");
        System.out.println(path3.getFileName());
        System.out.println(path3.getFileSystem());

    }

}
