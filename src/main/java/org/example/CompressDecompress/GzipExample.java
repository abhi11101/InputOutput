package org.example.CompressDecompress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipExample {

    static String FILE_TO_COMPRESS = "E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\checkVideo.mp4";
    static String FILE_TO_WRITE = "E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\checkVideo.gz";
    static String FILE_TO_DECOMPRESS = "E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\video.mp4";

    public static void main(String[] args) {

        try {

            System.out.println("Original Size: " + Files.size(Paths.get(FILE_TO_COMPRESS)));
            compress();
            decompress();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void compress(){

        byte[] buffer = new byte[1024];
        try(FileInputStream fileInputStream = new FileInputStream(FILE_TO_COMPRESS);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(FILE_TO_WRITE))) {

            int size;

            while ((size=fileInputStream.read(buffer))!=-1){
                gzipOutputStream.write(buffer,0,size);
            }

            System.out.println("File is compressed to the size: "+ Files.size(Paths.get(FILE_TO_WRITE)));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void decompress(){


            byte[] buffer = new byte[1024];

            try(GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(FILE_TO_WRITE));
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_TO_DECOMPRESS)) {
            int size;
                while ((size=gzipInputStream.read(buffer))!=-1){

                    fileOutputStream.write(buffer,0,size);
                }

                System.out.println("Decompressed file size is :" + Files.size(Paths.get(FILE_TO_DECOMPRESS)));


            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
