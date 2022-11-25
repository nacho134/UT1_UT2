package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ejercicios {
    @XmlElement(name="ejercicio")
    private ArrayList<Ejercicio> Ejercicios;
    public Ejercicios()
    {
        Ejercicios =new ArrayList<>();
    }

    public void addEjercicio(Ejercicio Ejercicio)
    {
        Ejercicios.add(Ejercicio);
    }

    public void muestraEjercicio()
    {
        for(Ejercicio Ejercicio: Ejercicios)
            System.out.println(Ejercicio);
    }
}
