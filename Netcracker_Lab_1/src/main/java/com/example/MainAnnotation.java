package com.example;

import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;
import com.example.services.ListToControlPersons;
import com.example.services.readCSVFile;
import com.example.sort.SortInterface;
import com.example.sort.Sorted;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class MainAnnotation {

    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        LOGGER.log(Level.INFO,"Начало main!");
        readCSVFile rcf = new readCSVFile("persons.csv");
        IPersonRepository personRepository = ListToControlPersons.Convert(rcf.read());
        LOGGER.log(Level.INFO, "Создан репозиторий");
        var managerClass = new ManagerClass<IPersonRepository>();
        LOGGER.log(Level.INFO,"Добавлен интерфейс");
        managerClass.addInterface(personRepository);
        LOGGER.log(Level.INFO,"Перед сортировкой!");
        personRepository.sortedWithHelpInterface((op1 , op2) -> op1.getAge() - op2.getAge());
        out.println(personRepository);
    }
}
