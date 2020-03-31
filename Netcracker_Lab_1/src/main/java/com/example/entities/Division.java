package com.example.entities;

import com.example.entities.IDivision;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "division")
public class Division implements IDivision {

    private String name;
    private Integer id;

    public Division() {

    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
