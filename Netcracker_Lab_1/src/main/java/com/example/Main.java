package com.example;


import org.joda.time.LocalDate;

import static java.lang.System.out;
public class Main {

    public static void main(String[] args)
    {
        Person person = new Person(new LocalDate(1834 , 6, 17),
                123, "Вассилий Васильевич Васильев");
        Person person2 = new Person(new LocalDate(1835 , 6, 17),
                123, "Вассилий Васильевич Игорев");
        Person person3 = new Person(new LocalDate(1838 , 6, 17),
                123, "Вассилий Игорьевич Васильев");
        Person person4 = new Person(new LocalDate(2191 , 6, 17),
                123, "Игорь Васильевич Васильев");
        out.print(person.Age());

        ControlPersons cp = new ControlPersons(2);
        cp.add(person);
        cp.add(person2);
        cp.add(person3);
        cp.add(person4);
        cp.delete(person4);
        out.print(cp);
    }
}
