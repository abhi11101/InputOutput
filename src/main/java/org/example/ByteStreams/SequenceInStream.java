package org.example.ByteStreams;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInStream {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\DataFile.txt");
        File file2 = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\MyFile.txt");

        String data = "This is data from byte array";
        byte[] bytes = data.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        try(FileInputStream fileInputStream = new FileInputStream(file);
            FileInputStream fileInputStream2 = new FileInputStream(file2)) {

            SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream,fileInputStream2);
            int read =0;
            while ((read = sequenceInputStream.read())!=-1){
                System.out.print((char)read);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println();
        try(FileInputStream fileInputStream = new FileInputStream(file);
            FileInputStream fileInputStream2 = new FileInputStream(file2))  {

//            SequenceInputStream sequenceInputStream = new SequenceInputStream(new SequenceInputStream(fileInputStream,fileInputStream2),byteArrayInputStream);
//
//            int read =0;
//            while ((read = sequenceInputStream.read())!=-1){
//
//                System.out.print((char)read);
//
//            }

            // Through Vector

            Vector<InputStream> inputStreamVector = new Vector<>();
            inputStreamVector.add(fileInputStream);
            inputStreamVector.add(fileInputStream2);
            inputStreamVector.add(byteArrayInputStream);

            Enumeration<InputStream> enumeration = inputStreamVector.elements();

            SequenceInputStream stream = new SequenceInputStream(enumeration);

            int read = 0;
            while ((read = stream.read())!=-1){
                System.out.print((char)read);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
