package com.solvd.sciencelab;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Employee;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRunner {

    private static final Logger LOGGER = LogManager.getLogger(JsonRunner.class);

    public static void main(String[] args) throws IOException {
        LOGGER.info(JsonLabReader());
        JsonLabWriter();
    }

    public static Laboratory JsonLabReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/resources/JsonLaboratory.json");
        Laboratory lab = objectMapper.readValue(file, Laboratory.class);
        return lab;
    }

    public static void JsonLabWriter() {
        ObjectMapper objectMapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/resources/JsonLabOutput.json");
        List<Laboratory> laboratoryList = new ArrayList<>();

        LabSize labSize = new LabSize("Very big", 320);
        labSize.setLabSizeId(1);
        City city = new City("Sevilla");
        city.setCityId(45);
        Laboratory laboratory = new Laboratory("National Lab", 1200, labSize, city);
        Employee employeeOne = new Employee(1, "Carlos", "Perez");
        Employee employeeTwo = new Employee(2, "Raul", "Carrasco");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
        laboratory.setEmployees(employeeList);
        laboratoryList.add(laboratory);

        labSize = new LabSize("Very little", 50);
        labSize.setLabSizeId(2);
        city = new City("Brighton");
        city.setCityId(21);
        laboratory = new Laboratory("International Lab", 300, labSize, city);
        employeeOne = new Employee(3, "Bautista", "Zambrano");
        employeeTwo = new Employee(4, "Milton", "Keynes");
        List<Employee> anotherEmployeeList = new ArrayList<>();
        anotherEmployeeList.add(employeeOne);
        anotherEmployeeList.add(employeeTwo);
        laboratory.setEmployees(anotherEmployeeList);
        laboratoryList.add(laboratory);

        try {
            objectMapper.writeValue(file, laboratoryList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Finished process.");
    }
}
