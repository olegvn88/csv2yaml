package com.csv2yaml;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunConverter {
    public static void main(String[] args) {
        readFromCSV().get(0);
    }

    private static InputStream readFromFile() {
        InputStream input = null;
        try {
            input = new FileInputStream(new File("src/main/resources/input_data.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    private static List<String[]> readFromCSV() {
        FileReader filereader = null;
        String fileName = "src/main/resources/input_data.csv";
        String[] cell = null;
        List<String[]> result = new ArrayList<>();
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(fileName));
            while (true) {
                try {
                    if (((cell = csvReader.readNext()) != null)) {
                        result.add(cell);
                    }
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
//                System.out.println(cell[0].split(";")[0]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static String convertToYAML(Map<String, Map<String, String>> map) {
        Yaml yaml = new Yaml();
        return yaml.dump(map);
    }

    private static String convertToYAML(List<String[]> list) {
        Yaml yaml = new Yaml();
        return yaml.dump(list);
    }

    private static void createYAMLFile(String output) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/converter/out/result.yaml"));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }

    private static Map<String, Map<String, String>> createMap() {
        Map<String, Map<String, String>> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, String> map2 = new HashMap<>();
            map2.put("key1" + i, "value1" + i);
            map2.put("key2" + i, "value2" + i);
            map2.put("key3" + i, "value4" + i);
            map.put("key" + i, map2);
        }
        return map;
    }
}
