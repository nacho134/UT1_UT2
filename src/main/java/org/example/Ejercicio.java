package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ejercicio {
    private int reps;
    private int peso;
    private String nombre;
    public Ejercicio() {
    }

    ;

    public Ejercicio(String nombre, int reps, int peso) {
        this.nombre = nombre;
        this.reps = reps;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }



    @Override
    public String toString() {
        return "disco{" +
                "nombre='" + nombre + '\'' +
                ", reps=" + reps +
                ", peso='" + peso + '\'' +
                '}';
    }




}