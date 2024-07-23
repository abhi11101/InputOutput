package org.example.SerializationDeserialization.Externalization;

import java.io.*;

public class MainClass {

    public static void main(String[] args) {

        Subtitles subtitles = new Subtitles();
        subtitles.setEngSub("DEMO ENGLISH SUBTITLES");
        String filename = "E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\Externalize.bin";
        serialize(subtitles,filename);
        Subtitles subtitles1 = (Subtitles) deserialize(filename);
        System.out.println(subtitles1);
    }

    public static void serialize(Subtitles subs, String fileName){

        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(subs);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName){

        try(FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            Object object = objectInputStream.readObject();

            return object;

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
