package org.example.ByteStreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintOStream {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\PrintOutput.txt");


        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            PrintStream p = new PrintStream(fileOutputStream);
            p.println("String data using Stream");
            p.println(8);
            p.println(6435.544);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
