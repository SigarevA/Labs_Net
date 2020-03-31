package com.example.XMLSample;

import com.example.entities.Division;
import com.example.entities.Person;
import com.example.entities.enums.Gender;
import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;

public class SAXreader extends DefaultHandler {


    private static final Logger LOG =  LogManager.getLogger(SAXreader.class.getName());


    private IPersonRepository persons;
    private Division tempDivision;
    private Person person;
    private String intervalName;
    private String tag;

    public SAXreader(IPersonRepository persons) {
        this.persons = persons;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        tag = qName;
        if  (qName.equals("division")){
            this.intervalName = "division";
            tempDivision = new Division();
        }
        if (qName.equals("person")) {
            person = new Person();
        }

    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String information = new String(ch, start, length);
        information = information.trim().replace("\n", "");
        if (information == "") return;
        switch (tag) {
            case "id" :
                Integer id = Integer.valueOf(information);
                if (intervalName.equals("division")) {
                    tempDivision.setId(id);
                }
                else {
                    person.setId(id);
                }
                break;

            case "name":
                tempDivision.setName(information);
                break;

            case "birthdate" :
                person.setBirthdate(LocalDate.parse(information));
                break;
            case "firstName":
                person.setFirstName(information);
                break;

            case "gender" :
                person.setGender(Gender.valueOf(information));
                break;
            case "LastName":
                person.setLastName(information);
                break;

            case "salary":
                person.setSalary(BigDecimal.valueOf(Double.parseDouble(information)));
                break;

        }

    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        LOG.debug("Start reading document xml with SAX");
        intervalName = "person";
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ( qName.equals("division")) {
            intervalName = "person";
            person.setDivision(tempDivision);
            tempDivision = null;
        }
        if (qName.equals("person")) {
            persons.add(person);
        }
        tag="null";
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        LOG.debug("End reading xml with SAX");
    }
}
