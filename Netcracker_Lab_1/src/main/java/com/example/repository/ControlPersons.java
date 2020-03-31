package com.example.repository;

import com.example.XMLSample.SAXreader;
import com.example.entities.IPerson;
import com.example.entities.Person;
import com.example.repository.IPersonRepository;
import com.example.repository.IRepository;
import com.example.sort.Ponderability;
import com.example.sort.SortInterface;
import com.example.sort.Sorted;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.arraycopy;

/***
 * Класс для работы и хранения эземпляров Person
 * методы :
 *      Добавить
 *      найти индекс конкретного обьекта
 *      Удалить
 */

@XmlRootElement(name="persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class ControlPersons implements IPersonRepository {

    @XmlTransient
    private static final Logger LOG =  LogManager.getLogger(SAXreader.class.getName());


    @XmlTransient
    @Sorted("BubbleSort")
    SortInterface sortInterface;

    @XmlElement(name="person")
    private Person[] persons;

    @XmlAttribute(name = "количество")
    private int numberofAddedPersonality;

    /***
     * @return количество
     */
    public int getNumberofAddedPersonality() {
        return numberofAddedPersonality;
    }

    /***
     * @param numberofAddedPersonality
     */
    public void setNumberofAddedPersonality(int numberofAddedPersonality) {
        this.numberofAddedPersonality = numberofAddedPersonality;
    }

    public IPerson[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public ControlPersons() {
        this.persons = new Person[10];
        this.numberofAddedPersonality = 0;
    }

    /***
     * @param Spaciousness
     * Рекумендуемый значение парамаетр - 10
     */
    public ControlPersons(int Spaciousness) {
        if(Spaciousness < 5)
            Spaciousness = 5;
        this.persons = new Person[Spaciousness];
        this.numberofAddedPersonality = 0;
    }


    /***
     * Метод который добавляет экземпляр Person в массив
     */

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

    /***
     * @param person
     * @return
     * Ищет индекс person в коллекции
     */
    public int findindexPerson(Person person)
    {
        for(int i = 0; i < numberofAddedPersonality; i++)
        {
            if(persons[i].equals(person) )
                return i;
        }
        return -1;
    }

    /***
     * @param person
     * @return
     * Удаляет person из коллекции
     */
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

    /***
     * @param sortInterface
     * Сортировка массива persons
     * с любым
     */
    public void sorted (SortInterface<IPerson> sortInterface,
                        Comparator<IPerson> comparator) {
        sortInterface.sort (
                this.persons,
                comparator,
                this.numberofAddedPersonality
        );
    }


    public void sortedWithHelpInterface (Comparator<IPerson> Comparator) {
        sortInterface.sort (
                this.persons,
                Comparator,
                this.numberofAddedPersonality
        );
    }


    private void checklength() {
        if(persons.length == numberofAddedPersonality)
            persons = Arrays.copyOf(persons, (2 * persons.length));
    }

    /***
     * Метод который добавляет экземпляр Person в массив
     * @param person
     */
    @Override
    public void add(IPerson person) {
        if(persons.length == numberofAddedPersonality)
            persons = Arrays.copyOfRange(persons, 0 , (2 * persons.length));
        persons[numberofAddedPersonality] = (Person) person;
        LOG.debug("Add {} to repository.", person);
        LOG.debug("Count : {}" , numberofAddedPersonality );
        numberofAddedPersonality++;
    }


    @Override
    public Optional<IPerson> get(int index) {
        Optional<IPerson> pos_person = Optional.empty();
        if(index < numberofAddedPersonality){
            pos_person = Optional.of(persons[index]);
        }
        return pos_person;
    }


    @Override
    public Optional<IPerson> delete(int index) {
        if(index >= numberofAddedPersonality)
            return Optional.empty();
        Optional<IPerson> res = Optional.of(persons[index]);
        System.arraycopy(persons, index + 1, persons, index, numberofAddedPersonality - 1 - index);
        numberofAddedPersonality--;
        return res;
    }


    @Override
    public IPerson set(int index, IPerson person) {
        this.checklength();
        if(index > numberofAddedPersonality)
            index = numberofAddedPersonality;
        IPerson result_person = persons[index];
        persons[index] = (Person) person;
        return result_person;
    }

    @Override
    public void add(int index, IPerson person) {
        if (index > numberofAddedPersonality) {
            return;
        }
        checklength();
        var rigthPart= Arrays.copyOfRange( persons ,index, numberofAddedPersonality);
        persons[index] = (Person) person;
        var leftPart = Arrays.copyOfRange(persons, 0, index + 1);
        arraycopy(leftPart , 0 , persons,  0, index );
        arraycopy(rigthPart, 0 , persons, index + 1, numberofAddedPersonality - index );
        numberofAddedPersonality++;
    }


    @Override
    public List<IPerson> toList() {
        List<IPerson> list = new LinkedList<IPerson>();
        for(int i = 0; i < numberofAddedPersonality; i++)
        {
            list.add(persons[i]);
        }
        return list;
    }

    @Override
    public void sortBy(Comparator<IPerson> comparator) {
        Arrays.sort(this.persons,0 , numberofAddedPersonality, comparator );
    }


    @Override
    public IRepository<IPerson> searchBy(Predicate<IPerson> condition) {

        IRepository<IPerson> reposetory = new ControlPersons(5);

        for (IPerson person : persons){
            if (condition.test(person)){
                reposetory.add(person);
            }
        }

        return reposetory;
    }
}