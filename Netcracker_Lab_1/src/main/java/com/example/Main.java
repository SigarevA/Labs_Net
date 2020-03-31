package com.example;


import com.example.XMLSample.JAXBmanagePerson;
import com.example.repository.IPersonRepository;
import com.example.services.ListToControlPersons;
import com.example.services.readCSVFile;

import javax.xml.bind.JAXBException;

import static java.lang.System.out;

import java.io.IOException;

public class Main {


    /***
     * @param args
     * @throws IOException
     * @throws JAXBException
     * Запись из файла csv в xml с помощью jaxb
     */
    public static void main(String[] args) throws IOException, JAXBException {
        readCSVFile rcf = new readCSVFile("persons.csv");
        IPersonRepository personRepository = ListToControlPersons.Convert(rcf.read());
        out.println(personRepository.toString());

        JAXBmanagePerson jaxBmanagePerson = new JAXBmanagePerson();
        jaxBmanagePerson.writeToXML(personRepository);

    }
}
