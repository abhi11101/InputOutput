package org.example.CharacterStreams;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayReaderWriter {

    public static void main(String[] args) {

        String message = "Goku, the protagonist of the iconic anime and manga series Dragon Ball, is a Saiyan warrior known for his boundless enthusiasm and remarkable strength. With a heart as pure as his fighting spirit, Goku is driven by an insatiable curiosity and a desire to protect those he cares about. His journey from a naive, powerful child to a formidable hero embodies themes of growth and perseverance. Through intense training and numerous battles, Goku continually pushes his limits, striving to become stronger and to confront increasingly formidable adversaries. His iconic spiky hair, cheerful personality, and unwavering determination make him a beloved character in the world of anime and a symbol of the heroic ideal.";
        char[] chars = message.toCharArray();

        try(CharArrayReader charArrayReader = new CharArrayReader(chars);
            CharArrayWriter charArrayWriter = new CharArrayWriter())    {

            char[] buffer = new char[3];

            while (charArrayReader.read(buffer) !=-1){

                charArrayWriter.write(buffer);
            }

            char[] array = charArrayWriter.toCharArray();

            System.out.println(array.length);
            for (char s: array){
                System.out.println(s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }



    }

}
