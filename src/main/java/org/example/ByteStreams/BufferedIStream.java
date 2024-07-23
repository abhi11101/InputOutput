package org.example.ByteStreams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedIStream {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\DataFile.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)){

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int bytesRead = 0;

            while ((bytesRead = bufferedInputStream.read()) != -1) {
                System.out.print((char) bytesRead);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
