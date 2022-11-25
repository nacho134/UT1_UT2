package org.example.raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Objetos Empleado (id, nombre, salario) con opciones de alta y consulta en un fichero RAF
 *
 */
public class raf1
{

    private static final int SIZE = 50;
    private static RandomAccessFile raf = null;
    private static Scanner ent = null;
    public static void main( String[] args ){
        int opc;
        try {
            raf = new RandomAccessFile("ejercicios.dat","rw"); // el segundo parámetro es el modo de lectura (read and rwite)
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\tBBDD GYM\n1- Nuevo Ejercicio\n2- Consulta de ejercicio\n\tEscoja la opción");
        ent = new Scanner(System.in);
        opc = ent.nextInt();
        switch (opc){
            case 1: altaEjercicio(); break;
            case 2: consultaEjercicio(); break;
            default:
                System.out.println("Fin del programa");
                System.exit(0);
        }
    }
    public static void altaEjercicio(){
        int id; String ejercicio; int peso; int reps;
        System.out.println("Introduce identificador del ejercicio ");
        id = ent.nextInt();
        System.out.println("Introduce el peso del ejercicio");
        peso = ent.nextInt();
        System.out.println("Introduce las reps del ejercicio");
        reps = ent.nextInt();
        ent.nextLine();
        System.out.println("Introduce el nombre del ejercicio");
        ejercicio = ent.nextLine();

        //antes de escribir me posiciono en el lugar adecuado
        try {
            raf.seek((long)(id-1)*SIZE);
            raf.writeInt(id);
            raf.writeInt(peso);
            raf.writeInt(reps);
            raf.writeUTF(ejercicio);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consultaEjercicio(){
        int idConsulta; int id; String ejercicio; int peso; int reps;
        System.out.println("Introduce el identificador  a consultar:");
        idConsulta = ent.nextInt();
        //nos posicionamos según el valor de identificador
        try {
            raf.seek((long)(idConsulta-1)*SIZE);
            id = raf.readInt();
            if(id == idConsulta){ // he encontrado el que buscaba
                peso = raf.readInt();
                reps = raf.readInt();
                ejercicio = raf.readUTF();

                System.out.println("\tId: "+id+"\nPeso: "+peso+"\nReps: "+reps+"\nEjercicio"+ejercicio);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}