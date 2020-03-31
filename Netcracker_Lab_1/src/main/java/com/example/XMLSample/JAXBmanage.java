package com.example.XMLSample;

import com.example.repository.IPersonRepository;
import com.example.repository.IRepository;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface JAXBmanage <T extends IRepository> {

    void writeToXML(T t) throws JAXBException, IOException;
    T readXML(String path);

}
