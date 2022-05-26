package com.solvd.sciencelab;

import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.Employee;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import jakarta.xml.bind.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbRunner {
    private static final Logger LOGGER = LogManager.getLogger(JaxbRunner.class);

    public static void main(String[] args) {
//        createLabXML();
        readXML();
    }

    public static void createLabXML() {
        try {
            Laboratory lab = new Laboratory();

            LabSize labSize = new LabSize();
            labSize.setLabSizeId(1);
            labSize.setLabSize("Tiny");
            labSize.setSquareMeters(47);

            City city = new City();
            city.setCityId(1);
            city.setCityName("Coronel Du Graty");

            List<Employee> employees = new ArrayList<>();
            Employee emp = new Employee();
            emp.setEmployeeId(1);
            emp.setFirstName("Juan");
            emp.setLastName("Talarga");
            employees.add(emp);

            emp = new Employee();
            emp.setEmployeeId(2);
            emp.setFirstName("Dario");
            emp.setLastName("Gazzola");
            employees.add(emp);

            lab.setName("Guemes");
            lab.setExpCapacity(59);
            lab.setLabsize(labSize);
            lab.setCity(city);
            lab.setEmployees(employees);

//            JAXB context
            JAXBContext ctx = JAXBContext.newInstance(Laboratory.class);
//            Convertion of Java into XML
            Marshaller ms = ctx.createMarshaller();
//            Preparing format of the XML file
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(lab, new File("src/main/resources/JAXBlabs.xml"));

        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readXML() {
        try {
//            creating JAXB context
            JAXBContext ctx = JAXBContext.newInstance(Laboratory.class);
            Unmarshaller ums = ctx.createUnmarshaller();

            Laboratory lab = (Laboratory) ums.unmarshal(new File("src/main/resources/JAXBemployeesUnmarshal.xml"));

            for (Employee emp : lab.getEmployees()) {
                LOGGER.info(emp.getEmployeeId() + " " + emp.getFirstName() + " " + emp.getLastName());
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
