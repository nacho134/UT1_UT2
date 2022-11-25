package org.example.raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.ServerError;
import java.sql.SQLException;
import java.util.Scanner;

public class raf2
{
    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args)
    {
        try( RandomAccessFile raf = new RandomAccessFile("datos2.dat","rw");)
        {
            int pos;double n;
            System.out.println("Introduce pos 0 no entra");

            pos=ent.nextInt();
            while(pos!=0)
            {
                System.out.println("Introduce el valor");
                n=ent.nextDouble();
                raf.seek((long)n*8);
                raf.writeDouble(n);
                System.out.println("Para salir 0");
                pos= ent.nextInt();
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }



    }
}
