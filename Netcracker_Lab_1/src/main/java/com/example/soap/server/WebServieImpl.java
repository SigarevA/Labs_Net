package com.example.soap.server;

import com.example.entities.IPerson;
import com.example.entities.enums.Gender;
import com.example.repository.ControlPersons;
import com.example.soap.server.PersonWebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.jws.WebService;
import javax.xml.parsers.ParserConfigurationException;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.example.XMLSample.Main.getControlPerson;


@WebService(endpointInterface = "com.example.soap.server.PersonWebService", targetNamespace = "http://soap.netcraker.ru/")
public class WebServieImpl implements PersonWebService {

    private static final Logger LOG =  LogManager.getLogger(WebServieImpl.class.getName());

    @Override
    /***
     * ВОзвращает количество женщин из person
     */
    public long getCountMalePersons() throws ParserConfigurationException, SAXException {

        ControlPersons cp = getControlPerson();
        cp.toList().forEach(LOG::debug);
        return cp.toList()
                .stream()
                .filter(x -> x.getGender() == Gender.FEMALE)
                .count();
    }

}