package org.example.nio;

import java.nio.*;
import  java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nio {
    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Introduce el fichero que deseas copiar:\n");
        String archivo=ent.nextLine();
        System.out.println("Introduce el nombre al que quieres cambiar el archivo:\n");
        String newarchivo= ent.nextLine();
        try (RandomAccessFile raf = new RandomAccessFile(archivo,"rw");FileChannel fileChannelReader = raf.getChannel();){
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            Path copied = Paths.get(newarchivo);
            Set<StandardOpenOption> options = new HashSet<>();
            options.add(StandardOpenOption.CREATE);
            options.add(StandardOpenOption.APPEND);
            FileChannel fileChannelWriter = FileChannel.open(copied,options);

            while(fileChannelReader.read(byteBuffer)>0)
            {
                byteBuffer.flip();
                fileChannelWriter.write(byteBuffer);
            }

            fileChannelWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}