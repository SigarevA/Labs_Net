package com.example.entities;

import com.example.adapters.LocalDateAdapter;
import com.example.entities.IDivision;
import com.example.entities.IPerson;
import com.example.entities.enums.Gender;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

/***
 * Класс Person
 */

@XmlType(name = "person")
public class Person implements IPerson {

    private LocalDate birthdate;
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private BigDecimal salary;
    @XmlElement(name = "division")
    private Division division;

    public void setId(int id) {
        this.id = id;
    }



    public Person(LocalDate birthdate, int id) {
        this.birthdate = birthdate;
        this.id = id;
    }


    public Person(){ }

    /***
     * @return id
     */
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    @XmlElement(name = "LastName")
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void setBirthdate( LocalDate birthDay) {
        this.birthdate = birthDay;
    }


    @Override
    public Integer getAge() {
        LocalDate nowdate = LocalDate.now();
        int approxim = 0;
        if(nowdate.getMonthOfYear() - birthdate.getMonthOfYear() < 0)
            approxim = 1;
        else if(nowdate.getMonthOfYear() - birthdate.getMonthOfYear() == 0)
            if (nowdate.getDayOfYear() - birthdate.getDayOfYear() < 0)
                approxim = 1;
        return nowdate.getYear() - birthdate.getYear() - approxim;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public Division getDivision() {
        return this.division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = (Division) division;
    }

    @Override
    public BigDecimal getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthdate +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + lastName + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", division=" + division +
                '}';
    }
}
