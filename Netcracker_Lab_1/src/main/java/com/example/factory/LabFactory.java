package com.example.factory;

import com.example.entities.Division;
import com.example.entities.IDivision;
import com.example.entities.IPerson;
import com.example.entities.Person;
import com.example.factory.ILabFactory;
import com.example.repository.ControlPersons;
import com.example.repository.IPersonRepository;
import com.example.repository.IRepository;

public class LabFactory implements ILabFactory {


    @Override
    public IPerson createPerson() {
        return new Person();
    }

    @Override
    public IDivision createDivision() {
        return new Division();
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return new ControlPersons(5);
    }
}
