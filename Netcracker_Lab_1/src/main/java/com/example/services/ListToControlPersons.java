package com.example.services;

import com.example.entities.IDivision;
import com.example.entities.IPerson;
import com.example.entities.Person;
import com.example.entities.enums.Gender;
import com.example.repository.ControlPersons;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.example.factory.LabFactory;
import com.example.repository.IPersonRepository;
import org.joda.time.LocalDate;

public class ListToControlPersons {

    public static IPersonRepository Convert(List<String[]> rows){

        LabFactory labFactory = new LabFactory();
        IPersonRepository personRepository = labFactory.createPersonRepository();

        int num = 1 ;
        for ( String[] line : rows ) {
            IPerson person = labFactory.createPerson();
            fillInfPerson(person, Arrays.copyOfRange(line, 0, 4));
            IDivision division = labFactory.createDivision();
            division.setId(num);
            division.setName(line[4]);
            person.setDivision(division);
            Double val = Double.valueOf(line[5]);
            person.setSalary(BigDecimal.valueOf(val));
            num++;
            personRepository.add(person);
        }
        return personRepository;
    }

    private static void fillInfPerson(IPerson person, String[] arr){
        person.setId(Integer.parseInt(arr[0]));
        person.setFirstName(arr[1]);
        person.setGender(Gender.valueOf(arr[2].toUpperCase()));
        person.setBirthdate(createLocalDate(arr[3]));
    }

    private static LocalDate createLocalDate(String data){
        String[] arr = data.split("\\.");

        int year = Integer.parseInt(arr[2]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[0]);
        return new LocalDate(year, month, day);
    }
}
