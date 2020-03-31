package com.example.soap.client;

import com.example.soap.server.PersonWebService;
import com.example.soap.server.WebServieImpl;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Клиент SOAP
 */
public class ClientWevService {

    public static void main(String[] args) throws MalformedURLException, MalformedURLException, ParserConfigurationException, SAXException {

        URL url = new URL("http://localhost:1234/wss/persons?wsdl");


        QName qname = new QName("http://soap.netcraker.ru/", "WebServieImplService");

        Service service = Service.create(url, qname);

        PersonWebService personService = service.getPort(PersonWebService.class);

        System.out.println(personService.getCountMalePersons());
    }

}
