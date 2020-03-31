package com.example.XMLSample;

import com.example.entities.IPerson;
import com.example.entities.Person;
import com.example.factory.LabFactory;
import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JAXBmanagePerson implements JAXBmanage<IPersonRepository> {


    @Override
    public void writeToXML(IPersonRepository controlPersons) throws JAXBException, IOException {

        FileWriter fileWriter = new FileWriter("./test.xml");

        JAXBContext context = JAXBContext.newInstance(ControlPersons.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(controlPersons, fileWriter);

    }

    @Override
    public IPersonRepository readXML(String path) {

        return null;
    }
}
