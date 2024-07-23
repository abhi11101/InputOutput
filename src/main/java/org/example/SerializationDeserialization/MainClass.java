package org.example.SerializationDeserialization;

import java.io.*;

public class MainClass {

    public static void main(String[] args) {

        User user = new User();
        user.setId(101);
        user.setUserName("Naruto");
        user.setPassword("Kamehameha");
        Player player = new Player();
        player.setLevel(55);
//        player.setUserName("Vegeta");
        player.setPoints(34567);
        player.setUserDetails(user);
        serialize(player, "E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\SerializeDeserialize.bin");
        deserialize("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\SerializeDeserialize.bin");

    }

    public static void serialize(Player player, String fileName) {

        try(FileOutputStream fileOutputStream = new  FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(player);


        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deserialize(String fileName) {

        try(FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Player player = (Player) objectInputStream.readObject();
            System.out.println(player);

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
