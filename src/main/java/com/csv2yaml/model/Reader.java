package com.csv2yaml.model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static void main(String[] args) throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_data.csv"));

        List<Product> productList = new ArrayList<>();

        // read line by line
        String[] record = null;
        String[] record2 = null;


        List<String[]> list = new ArrayList<>();
        List<String[]> list2 = new ArrayList<>();
        while ((record = reader.readNext()) != null) {
           list.add(record);
        }
        for (int i = 0; i < list.size(); i++) {
        record2 = list.get(i)[0].split(";");
        list2.add(record2);
        }

        System.out.println(list2.get(0)[0]);
        System.out.println(list2.get(1)[0]);
        System.out.println(list2.get(2)[0]);
        System.out.println(list2.get(3)[0]);

        reader.close();
    }

}
