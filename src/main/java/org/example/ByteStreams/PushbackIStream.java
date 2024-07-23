package org.example.ByteStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class PushbackIStream {

    public static void main(String[] args) {

        String str = "if(a && b) return c & d";
        byte[] bytes = str.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);

        int data = 0;

        try {
            while ((data = pushbackInputStream.read())!=-1){

                switch (data){
                    case '&':
                        if ((data = pushbackInputStream.read())=='&'){
                            System.out.print("Logical-AND");
                        }else {
                            System.out.print("Bitwise-AND");
                            pushbackInputStream.unread(data);
                        }
                        break;
                    default : System.out.print((char)data);
                    break;

                };


            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
