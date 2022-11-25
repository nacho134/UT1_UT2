package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Ejercicio;
import org.example.Ejercicios;

import java.io.File;
//Inicio de la clase
public class jaxb {
    public static void main(String[] args) {
        //creo array list
        Ejercicios ejercicios = new Ejercicios();
        //Crear objetos
        Ejercicio e1 = new Ejercicio("nacho",4,5);
        Ejercicio e2 = new Ejercicio("sport",2,5);
        //añadirlos
        ejercicios.addEjercicio(e1);
        ejercicios.addEjercicio(e2);

        try
        {
            //Escribir xml
            JAXBContext context = JAXBContext.newInstance(Ejercicios.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(ejercicios,new File("ejerciciocopia.xml"));
            //Leemosel XML

            JAXBContext context2= JAXBContext.newInstance(Ejercicios.class);
            Unmarshaller unmarshaller= context2.createUnmarshaller();
            Ejercicios ejercicios2 = (Ejercicios) unmarshaller.unmarshal(new File("ejercicios.xml"));
            ejercicios2.muestraEjercicio();
        } catch (JAXBException e)
        {
            e.printStackTrace();

        }
    }
}