package org.example.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class leerXML {
    public static void main(String[] args) {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento =db.parse("ejercicios.xml");
            NodeList nodos= documento.getElementsByTagName("ejercicio");
            Node node;
            Element element;
            for(int i=0;i< nodos.getLength();i++)
            {
                node=nodos.item(i);
                element=(Element) node;
                System.out.println(((Element) node).getElementsByTagName("nombre").item(0).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
