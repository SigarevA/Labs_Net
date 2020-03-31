package com.example;

import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;
import com.example.services.ListToControlPersons;
import com.example.services.readCSVFile;
import com.example.sort.SortInterface;
import com.example.sort.Sorted;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Level;

import static java.lang.System.out;

public class MainAnnotation {

    private static final Logger LOG =  LogManager.getLogger(MainAnnotation.class.getName());

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        LOG.debug("Начало main!");
        readCSVFile rcf = new readCSVFile("persons.csv");
        IPersonRepository personRepository = ListToControlPersons.Convert(rcf.read());
        LOG.debug( "Создан репозиторий");
        var managerClass = new ManagerClass<IPersonRepository>();
        LOG.debug("Добавлен интерфейс");
        managerClass.addInterface(personRepository);
        LOG.debug("Перед сортировкой!");
        personRepository.sortedWithHelpInterface((op1 , op2) -> op1.getAge() - op2.getAge());
        out.println(personRepository);
    }
}
