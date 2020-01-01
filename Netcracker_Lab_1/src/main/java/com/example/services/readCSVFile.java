package com.example.services;

import com.opencsv.CSVReader;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("resourse")
public class readCSVFile {

    private String fileName;

    public readCSVFile(String fileName) {
        this.fileName = fileName;
    }

    private CSVReader createReadre() throws IOException
    {
        File file = new File(getClass().getClassLoader().getResource(this.fileName).getFile());
        return new CSVReader (new FileReader(file), ';', '"', 1);
    }

    public List<String[]> read() throws IOException
    {
        return createReadre().readAll();
    }

    public long countline() throws IOException {
        return createReadre().getLinesRead();
    }

}
