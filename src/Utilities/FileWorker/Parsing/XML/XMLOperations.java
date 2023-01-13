package Utilities.FileWorker.Parsing.XML;

import CalculationEngine.Engine.Calculator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLOperations {

    public ArrayList<String> parse(File file) throws IOException, ParserConfigurationException, SAXException {
        ArrayList<String> exampleList = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file.getName());
        Node root = document.getDocumentElement();
        NodeList examples = root.getChildNodes();
        for (int i = 0; i < examples.getLength(); i++) {
            Node example = examples.item(i);
            if (example.getNodeType() != Node.TEXT_NODE) {
                if (example.getNodeType() != Node.TEXT_NODE) {
                    exampleList.add(example.getChildNodes().item(0).getTextContent());
                }
            }
        }


        return exampleList;
    }
    public void write(ArrayList<String> list, String outFileName) throws IOException, XMLStreamException {
        int i = 0;
        for (String text:list) {
            list.set(i, Calculator.calculateExpression(text));
            i++;
        }

        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(outFileName));
        writer.writeStartDocument("UTF-8", "1.0");

        writer.writeStartElement("Math");
        for (int j = 0; j < i; j++) {
            writer.writeStartElement("example");
            writer.writeCharacters(list.get(j));
            writer.writeEndElement();
        }
        writer.writeEndElement();

        writer.writeEndDocument();
        writer.flush();
    }
}
