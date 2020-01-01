package com.example;


import com.example.repository.IPersonRepository;
import com.example.services.ListToControlPersons;
import com.example.services.readCSVFile;

import static java.lang.System.out;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        readCSVFile rcf = new readCSVFile("persons.csv");
        IPersonRepository personRepository = ListToControlPersons.Convert(rcf.read());
        out.println(personRepository.toString());
    }
}
