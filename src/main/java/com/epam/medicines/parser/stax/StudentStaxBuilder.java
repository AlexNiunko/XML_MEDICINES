package com.epam.medicines.parser.stax;

import com.epam.medicines.entity.Medicine;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentStaxBuilder {
    private List<Medicine> medicines;
    private XMLInputFactory inputFactory;

    public StudentStaxBuilder() {
        medicines = new ArrayList<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void buildListMedicines(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
