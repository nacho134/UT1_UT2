package org.example.XML;

import org.example.Ejercicio;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

class escribeXML{
    public static void main(String[] args) {
        try{
            ArrayList<Ejercicio> Ejercicios = new ArrayList<Ejercicio>();
            Ejercicios.add(new Ejercicio("DeadLift",23,50));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation domi = db.getDOMImplementation();
            Document docu = domi.createDocument(null,"xml",null);
            Element root = docu.createElement("ejercicios");
            docu.getDocumentElement().appendChild(root);
            Element nodoDatos,nodoDiscos;
            Text texto;
            for(Ejercicio d:Ejercicios)
            {
                nodoDiscos=docu.createElement("ejercicio");
                root.appendChild(nodoDiscos);

                nodoDatos=docu.createElement("nombre");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(d.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos=docu.createElement("reps");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(String.valueOf(d.getReps()));
                nodoDatos.appendChild(texto);

                nodoDatos=docu.createElement("peso");
                nodoDiscos.appendChild(nodoDatos);
                texto=docu.createTextNode(String.valueOf(d.getPeso()));
                nodoDatos.appendChild(texto);
            }
            Source source = new DOMSource(docu);
            Result result = new StreamResult(new File("ejercicios.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent","yes");
            transformer.transform(source,result);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
