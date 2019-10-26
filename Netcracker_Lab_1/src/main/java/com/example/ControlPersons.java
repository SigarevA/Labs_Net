package com.example;

import java.util.Arrays;

/***
 * Класс для работы и хранения эземпляров Person
 * методы :
 *      Добавить
 *      найти индекс конкретного обьекта
 *      Удалить
 */
public class ControlPersons{

    private Person[] persons;
    private int numberofAddedPersonality;

    public int getNumberofAddedPersonality() {
        return numberofAddedPersonality;
    }

    public void setNumberofAddedPersonality(int numberofAddedPersonality) {
        this.numberofAddedPersonality = numberofAddedPersonality;
    }

    public Person[] getPersons() {
        return persons;
    }

    /***
     * @param Spaciousness
     * Рекумендуемый значение парамаетр - 10
     */
    public ControlPersons(int Spaciousness) {
        this.persons = new Person[Spaciousness];
        this.numberofAddedPersonality = 0;
    }


    /***
     * Метод который добавляет экземпляр Person в массив
     * @param person
     */
    public void add(Person person)
    {
        if(persons.length == numberofAddedPersonality)
            persons = Arrays.copyOfRange(persons, 0 , (2 * persons.length));
        persons[numberofAddedPersonality] = person;
        numberofAddedPersonality++;
    }

    @Override
    public String toString() {
        String content = "";
        for(int i = 0; i < numberofAddedPersonality; i++)
        {
            content += "\n" + persons[i] + ",";
        }
        return "ControlPersons{" +
                "persons=" + content +
                '}';
    }

    public int findindexPerson(Person person)
    {
        for(int i = 0; i < numberofAddedPersonality; i++)
        {
            if(persons[i].equals(person) )
                return i;
        }
        return -1;
    }

    public boolean delete(Person person)
    {
        int index = findindexPerson(person);
        if(index == -1)
            return false;
        for(int i = index; i < numberofAddedPersonality - 1; i++)
        {
            persons[i] = persons[i+1];
        }
        numberofAddedPersonality--;
        return true;
    }
}