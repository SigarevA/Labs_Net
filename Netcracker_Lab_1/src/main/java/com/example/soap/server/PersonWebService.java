package com.example.soap.server;


import com.example.entities.IPerson;
import org.xml.sax.SAXException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.WebServiceRef;
import java.lang.annotation.Target;
import java.util.LinkedList;


@WebServiceRef
@WebService(targetNamespace = "http://soap.netcraker.ru/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonWebService {
    @WebMethod
    long getCountMalePersons() throws ParserConfigurationException, SAXException;
}
