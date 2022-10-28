package com.epam.medicines.parser.stax;

import com.epam.medicines.entity.*;
import com.epam.medicines.parser.MedicineEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedicineStaxBuilder {
    private List<Medicine> medicines;
    private XMLInputFactory inputFactory;

    public MedicineStaxBuilder() {
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
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(MedicineEnum.MEDICINE.getValue())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setName(reader.getAttributeValue(null, MedicineEnum.NAME.getValue()));
        medicine.setPharm(reader.getAttributeValue(null, MedicineEnum.PHARM.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case GROUP -> medicine.setGroup(getXMLText(reader));
                        case ANALOGS -> medicine.setAnalogsList(listAnalogs(getXMLText(reader)));
                        case VERSION -> medicine.setVersion(getXMLVersion(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MEDICINE) {
                        return medicine;
                    }
            }

        }
        throw new XMLStreamException("Unknow element in tag <medicine>");
    }

    private Version getXMLVersion(XMLStreamReader reader) throws XMLStreamException {
        Version version = new Version();
        version.setVersion_type(reader.getAttributeValue(null, MedicineEnum.VERSION_TYPE.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name= reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case CERTIFICATE -> version.setCertificate(getXMLCertificate(reader));
                        case MEDICINE_PACKAGE -> version.setMedicinePackage(getXMLMedicinePackage(reader));
                        case MEDICINE_DOSAGE -> version.setDosage(getXMLDosage(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.VERSION) {
                        return version;
                    }
            }

        }
        throw new XMLStreamException("Unknow element in tag <version>");
    }

    private Certificate getXMLCertificate(XMLStreamReader reader) throws XMLStreamException {
        Certificate certificate = new Certificate();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case NUMBER -> certificate.setNumber(getXMLText(reader));
                        case DATE_OF_ISSUE -> certificate.setDateOfIssue(getXMLText(reader));
                        case EXPIRATION -> certificate.setExpiration(getXMLText(reader));
                        case ORGANIZATION -> certificate.setOrganization(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name=reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase())==MedicineEnum.CERTIFICATE){
                        return certificate;
                    }
            }
        }
        throw new XMLStreamException("Unknow element in tag <certificate>");
    }


    private MedicinePackage getXMLMedicinePackage(XMLStreamReader reader) throws XMLStreamException {
        MedicinePackage medicinePackage=new MedicinePackage();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case PACKAGE_TYPE->medicinePackage.setType(getXMLText(reader));
                        case PACKAGE_AMOUNT -> medicinePackage.setAmount(Integer.parseInt(getXMLText(reader)));
                        case PACKAGE_PRICE -> medicinePackage.setPrice(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name=reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase())==MedicineEnum.MEDICINE_PACKAGE){
                        return medicinePackage;
                    }
            }
        }
        throw new XMLStreamException("Unknow element in tag <MedicinePackage>");
    }
    private Dosage getXMLDosage(XMLStreamReader reader) throws XMLStreamException {
        Dosage dosage=new Dosage();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case DOSAGE_AMOUNT -> dosage.setAmount(Integer.parseInt(getXMLText(reader)));
                        case DOSAGE_PERIOD -> dosage.setPeriod(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name=reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase())==MedicineEnum.MEDICINE_DOSAGE){
                        return dosage;
                    }
            }
        }
        throw new XMLStreamException("Unknow element in tag <dosage>");
    }




    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private List<Analogs> listAnalogs(String data) {
        String[] dataArray = data.split(",");
        List<String> datacollect = Arrays.stream(dataArray).collect(Collectors.toList());
        List<Analogs> analogs = datacollect.stream()
                .map(analog -> new Analogs(analog))
                .collect(Collectors.toList());
        return analogs;
    }
}
