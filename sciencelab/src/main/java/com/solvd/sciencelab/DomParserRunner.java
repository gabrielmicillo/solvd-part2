package com.solvd.sciencelab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserRunner {
    private static final Logger LOGGER = LogManager.getLogger(DomParserRunner.class);

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/employees.xml");
            NodeList employeeList = doc.getElementsByTagName("employee");
            for (int i = 0; i < employeeList.getLength(); i++) {
                Node e = employeeList.item(i);
                if (e.getNodeType() == Node.ELEMENT_NODE) {
                    Element employee = (Element) e;
                    String id = employee.getAttribute("id");
                    NodeList nameList = employee.getChildNodes();
                    for (int j = 0; j < nameList.getLength(); j++) {
                        Node n = nameList.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;
                            LOGGER.info("Employee " + id + ":" + name.getTagName() + "=" + name.getTextContent());
                        }
                    }

                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
