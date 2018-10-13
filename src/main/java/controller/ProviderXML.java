package controller;

import model.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProviderXML implements Provider {

    @Override
    public List<Currency> getData() {
        List<Currency> lista = new ArrayList<>();
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL("https://www.nbp.pl/kursy/xml/LastA.xml").openStream());

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("pozycja");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    lista.add(new Currency(eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("przelicznik").item(0).getTextContent()),
                            eElement.getElementsByTagName("kod_waluty").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("kurs_sredni").item(0).getTextContent().replaceAll(",", "."))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
