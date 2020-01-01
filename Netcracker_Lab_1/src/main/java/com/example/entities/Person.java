package com.example.entities;

import com.example.entities.IDivision;
import com.example.entities.IPerson;
import com.example.entities.enums.Gender;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

/***
 * Класс Person
 */
public class Person implements IPerson {

    private LocalDate birthDay;
    private int id;
    private String firstName;
    private String secondName;
    private Gender gender;
    private BigDecimal salary;
    private IDivision division;

    /***
     * @param birthDay
     * @param id
     */
    public Person(LocalDate birthDay, int id) {
        this.birthDay = birthDay;
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
    public String getLastName() {
        return this.secondName;
    }

    @Override
    public void setLastName(String lastName) {
        this.secondName = firstName;
    }

    @Override
    public LocalDate getBirthdate() {
        return this.birthDay;
    }

    @Override
    public void setBirthdate( LocalDate birthdate) {
        this.birthDay = birthdate;
    }

    @Override
    public Integer getAge() {
        LocalDate nowdate = LocalDate.now();
        int approxim = 0;
        if(nowdate.getMonthOfYear() - birthDay.getMonthOfYear() < 0)
            approxim = 1;
        else if(nowdate.getMonthOfYear() - birthDay.getMonthOfYear() == 0)
            if (nowdate.getDayOfYear() - birthDay.getDayOfYear() < 0)
                approxim = 1;
        return nowdate.getYear() - birthDay.getYear() - approxim;
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
    public IDivision getDivision() {
        return this.division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
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
                "birthDay=" + birthDay +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", division=" + division +
                '}';
    }
}
