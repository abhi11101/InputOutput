package org.example.ByteStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {

    public static void main(String[] args) {

        // Byte by Byte
//        byteByByte();

        //Byte Array
        byteArray();


    }

    public static void byteByByte(){

        try(FileInputStream fileInputStream  = new FileInputStream("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\DataFile.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\MyFile.txt")) {

            int byteRead =0;
            while (byteRead !=-1){
                byteRead = fileInputStream.read();
                System.out.print(byteRead);
                fileOutputStream.write(byteRead);
//                System.out.print((char)byteRead); //For converting to characters
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteArray(){

        File readFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\DataFile.txt");
        File writeFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\MyFile.txt");

        try(FileInputStream fileInputStream = new FileInputStream(readFile);
            FileOutputStream fileOutputStream = new FileOutputStream(writeFile)) {
            System.out.println("Available Bytes : "+fileInputStream.available());
            long size = readFile.length();
            byte[] bytes = new byte[(int)size];
            fileInputStream.read(bytes);
            fileOutputStream.write(bytes);
            for (byte b : bytes){
                System.out.print(b);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
