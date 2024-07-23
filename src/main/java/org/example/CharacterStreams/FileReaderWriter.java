package org.example.CharacterStreams;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

    public static void main(String[] args) {

        File readFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\Goku.txt");
        File printFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\FileWriter.txt");


        try(FileReader fileReader = new FileReader(readFile);
            FileWriter fileWriter = new FileWriter(printFile)) {

            int charRead ;
            while((charRead = fileReader.read()) != -1) {
                System.out.print((char)charRead);
                fileWriter.write((char)charRead);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
