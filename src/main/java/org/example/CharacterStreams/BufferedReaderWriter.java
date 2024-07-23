package org.example.CharacterStreams;

import java.io.*;

public class BufferedReaderWriter {

    public static void main(String[] args) {

        File readFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\Goku.txt");
        File writeFile = new File("E:\\Codes\\Practice_2023\\Java\\InputOutput\\MyDocuments\\WorkDocuments\\BufferedWriterOutput.txt");

        try(FileReader fileReader = new FileReader(readFile);
            FileWriter fileWriter = new FileWriter(writeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
             {


//                  Reading Chars
//                 int charRead = 0;
//
//                 while ((charRead = bufferedReader.read()) != -1){
//                     System.out.print((char)charRead);
//                     bufferedWriter.write(charRead);
//                 }

                 //Reading lines

                 String line ="";

                 while ((line = bufferedReader.readLine()) != null) {

                     bufferedWriter.write(line);
                     bufferedWriter.newLine();
                 }

        }catch (IOException e){

        }

    }

}
