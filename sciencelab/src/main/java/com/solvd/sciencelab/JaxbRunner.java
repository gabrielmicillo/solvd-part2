package com.solvd.sciencelab;

import jakarta.xml.bind.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbRunner {
    public static void main(String[] args) {
//        createXML();
        readXML();
    }

    public static void createXML(){
        try{
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

            Human hum = new Human();
            hum.setEmployees(employees);

//            JAXB context
            JAXBContext ctx = JAXBContext.newInstance(com.solvd.sciencelab.Human.class);
//            Convertion of Java into XML
            Marshaller ms = ctx.createMarshaller();
//            Preparing format of the XML file
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(hum, new File("src/main/resources/JAXBemployees.xml"));

        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readXML(){
        try{
//            creating JAXB context
            JAXBContext ctx = JAXBContext.newInstance(com.solvd.sciencelab.Human.class);
            Unmarshaller ums = ctx.createUnmarshaller();

            Human hum = (Human)ums.unmarshal(new File("src/main/resources/JAXBemployeesUnmarshal.xml"));

            for (Employee emp : hum.getEmployees()) {
                System.out.println(emp.getEmployeeId() + " " + emp.getFirstName() + " " + emp.getLastName());
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
