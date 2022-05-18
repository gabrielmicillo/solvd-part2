package com.solvd.sciencelab;

import com.solvd.sciencelab.entities.*;
import jakarta.xml.bind.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbRunner {
    private static final Logger LOGGER = LogManager.getLogger(JaxbRunner.class);

    public static void main(String[] args) {
//        createEmployeeXML();
        createOrderXML();
//        readXML();
    }

    public static void createEmployeeXML() {
        try {
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
            JAXBContext ctx = JAXBContext.newInstance(Human.class);
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

    public static void createOrderXML() {
        try {
            FinishedWork works = new FinishedWork();

            Client client = new Client(123, "Peter", "Gonzalez");
            Order order = new Order(63, 36, client);
            works.orders.add(order);

            Client anotherClient = new Client(126, "Antonio", "Cassano");
            Order anotherOrder = new Order(53, 45, anotherClient);
            works.orders.add(anotherOrder);

//            JAXB context
            JAXBContext ctx = JAXBContext.newInstance(FinishedWork.class);
//            Convertion of Java into XML
            Marshaller ms = ctx.createMarshaller();
//            Preparing format of the XML file
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(works, new File("src/main/resources/JAXBorders.xml"));

        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readXML() {
        try {
//            creating JAXB context
            JAXBContext ctx = JAXBContext.newInstance(Human.class);
            Unmarshaller ums = ctx.createUnmarshaller();

            Human hum = (Human) ums.unmarshal(new File("src/main/resources/JAXBemployeesUnmarshal.xml"));

            for (Employee emp : hum.getEmployees()) {
                LOGGER.info(emp.getEmployeeId() + " " + emp.getFirstName() + " " + emp.getLastName());
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
