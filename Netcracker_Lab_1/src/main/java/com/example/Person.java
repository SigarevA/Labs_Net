package com.example;

import org.joda.time.LocalDate;

/***
 * Класс Person
 */
public class Person {

    private LocalDate birthDay;
    private int id;
    private String FIO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /***
     * @param birthDay
     * @param id
     * @param FIO
     */
    public Person(LocalDate birthDay, int id, String FIO) {
        this.birthDay = birthDay;
        this.id = id;
        this.FIO = FIO;
    }
                                                                       

    public int Age()
    {
        LocalDate nowdate = LocalDate.now();
        return nowdate.getYear() - birthDay.getYear();
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthDay +
                ", id=" + id +
                ", FIO='" + FIO + '\'' +
                '}';
    }
}
