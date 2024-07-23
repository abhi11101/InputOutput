package org.example.DataStreams;

import java.io.*;

public class RandomAccess {

    public static void main(String[] args) {

        File file = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\RandomAccess.txt");

        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream) ){

            int[] codes = {3,67,5,32,8,1232,97};

            for (int code : codes) {
                dataOutputStream.writeInt(code);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        RandomAccessFile randomAccessFile = null;
        try {

            randomAccessFile = new RandomAccessFile(file,"rw");
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.seek(4);
            randomAccessFile.writeInt(91);

            randomAccessFile.seek(2*4);
            randomAccessFile.writeInt(192);


            System.out.println("-------------------------");

            randomAccessFile.seek(0);
            try {
                while (true){
                    System.out.println(randomAccessFile.readInt());
                }
            }catch (EOFException e){
                System.out.println("EOF");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
