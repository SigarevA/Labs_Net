package com.example;

import com.example.entities.IPerson;
import com.example.entities.Person;
import com.example.factory.LabFactory;
import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;
import com.example.services.ListToControlPersons;
import com.example.services.readCSVFile;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static java.lang.System.out;

public class ControlPersonsTest {

    @Test
    public void add() throws IOException {
        ControlPersons cp = new ControlPersons(5);
        readCSVFile rcf = new readCSVFile("persons.csv");
        IPersonRepository personRepository = ListToControlPersons.Convert(rcf.read());
        IPerson person = new Person();
        personRepository.add(4 , person);
        Optional<IPerson> result = personRepository.get(4);
        IPerson res_person = result.orElse(null);
        Assert.assertEquals(person, res_person);
    }

    @Test
    public void delete() {
        LabFactory lb = new LabFactory();
        IPersonRepository personRepository = lb.createPersonRepository();
        IPerson person = lb.createPerson();
        for (int i = 0 ; i < 10 ; ++i) {
            IPerson t_person = lb.createPerson();
            personRepository.add(t_person);
            if (i == 5)
                person = t_person;
        }
        Optional<IPerson> del_person = personRepository.delete(5);
        Assert.assertEquals(person , del_person.orElse(null));
    }

    @Test
    public void get() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void toList() {
    }

    @Test
    public void sortBy() {
        LabFactory lb = new LabFactory();
        IPersonRepository personRepository = lb.createPersonRepository();
        testdate(personRepository, lb, 2000, 11, 4);
        testdate(personRepository, lb, 1899, 11, 4);
        testdate(personRepository, lb, 1956, 11, 4);
        testdate(personRepository, lb, 2001, 11, 12);
        testdate(personRepository, lb, 2000, 12, 31);
        testdate(personRepository, lb, 1991, 5, 4);
        testdate(personRepository, lb, 1991, 1, 2);
        testdate(personRepository, lb, 1989, 3, 15);
        testdate(personRepository, lb, 1994, 4, 23);
        personRepository.sortBy(( IPerson person1 , IPerson person2 ) -> person1.getAge() - person2.getAge());
        out.print(personRepository);
    }

    @Test
    public void searchBy() {

    }

    private void testdate(
            IPersonRepository personRepository,
            LabFactory labFactory,
            int year,
            int month,
            int day)
    {
        IPerson person = labFactory.createPerson();
        LocalDate localDate = new LocalDate(year, month, day);
        person.setBirthdate(localDate);
        personRepository.add(person);
    }
}