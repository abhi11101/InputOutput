package org.example.NIO;

import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelBuffer {

    public static void main(String[] args) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putInt(121); //4 byte
        byteBuffer.putInt(133); //4 byte

        System.out.println("position: "+ byteBuffer.position()); // 8
        System.out.println("limit: "+ byteBuffer.limit());

        byteBuffer.flip();
        System.out.println("After flip");
        System.out.println("position: "+ byteBuffer.position());
        System.out.println("limit: "+ byteBuffer.limit());


        Path path = Paths.get("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\PersonalStuff\\NIOBuffer.bin");
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        fileChannel.write(byteBuffer);
        fileChannel.close();

        FileChannel readChannel = FileChannel.open(path, StandardOpenOption.READ);
        byteBuffer.clear();
        readChannel.read(byteBuffer);
        readChannel.close();

        byteBuffer.flip();

        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        try{


        while (true){
            System.out.println(intBuffer.get());
        }
        }catch (BufferUnderflowException e){
//            e.printStackTrace();
        }
//        function(path,byteBuffer);
    }

    public static void function(Path path, ByteBuffer byteBuffer) throws IOException {
        System.out.println("-----------------------");
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(16);
        byteBuffer.putInt(45);
        byteBuffer.putInt(88);
        byteBuffer.flip();

        System.out.println("func position: "+ byteBuffer.position());
        System.out.println("func limit: "+ byteBuffer.limit());
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        fileChannel.write(byteBuffer);
        fileChannel.close();

        FileChannel readChannel = FileChannel.open(path,StandardOpenOption.READ);
        byteBuffer.clear();
        readChannel.read(byteBuffer);
        readChannel.close();

        byteBuffer.flip();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        try{
            while (true){
                System.out.println(intBuffer.get());
            }
        }catch (BufferUnderflowException e){

        }

    }

}
