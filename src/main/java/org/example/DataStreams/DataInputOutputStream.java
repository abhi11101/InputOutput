package org.example.DataStreams;

import java.io.*;

public class DataInputOutputStream {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\DataOutput.txt");

        try(FileOutputStream fileInputStream = new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(fileInputStream))    {

            String[] items = {"Coffee","Shoes","Tea"};
            double[] costs = {25,300,50};

            for (int i = 0; i < items.length; i++) {
                dataOutputStream.writeLong(i+1);
                dataOutputStream.writeUTF(items[i]);
                dataOutputStream.writeDouble(costs[i]);

            }
        }catch (IOException e) {
            e.printStackTrace();
        }


        try(FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {

            long sNo;
            String item;
            double cost;
            double total=0.0;

            try {
                while (true){
                    sNo = dataInputStream.readLong();
                    item = dataInputStream.readUTF();
                    cost = dataInputStream.readDouble();
                    total+=cost;
                    System.out.println(String.format("%d You ordered %s + at $%.2f",sNo,item,cost));
                }
            }catch (EOFException e){
                System.out.println("EOF");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
