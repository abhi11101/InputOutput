package org.example.ByteStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayIOStream {

    public static void main(String[] args) {

        String message = "Let's learn about in-memory streams";
        byte[] bytes = message.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int bytesRead = 0;
        int counter =0;
        byte[] buffer = new byte[3];
        try{
            while ((bytesRead = byteArrayInputStream.read(buffer)) !=-1){
                System.out.println(bytesRead);
                counter++;
                byteArrayOutputStream.write(buffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("counter is " + counter);

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        for (byte b : byteArray) {
            System.out.print((char) b);
        }

    }
}
