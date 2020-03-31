package com.example.XMLSample;

import com.example.repository.ControlPersons;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final Logger LOG =  LogManager.getLogger(SAXreader.class.getName());


    /***
     * Чтение из xml
     * @param args
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void main (String[] args ) throws ParserConfigurationException, SAXException, IOException {
        ControlPersons controlPersons = getControlPerson();
        System.out.println(controlPersons);
    }


    public static ControlPersons getControlPerson() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        ControlPersons controlPersons = new ControlPersons(5);
        SAXreader handler = new SAXreader(controlPersons);
        try {
            parser.parse(new File("./test.xml"), handler);
        }
        catch (IOException e) {
            LOG.error(e);
            e.fillInStackTrace();
        }
        return controlPersons;
    }

}
