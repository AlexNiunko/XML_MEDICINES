package com.epam.medicines.parser.sax;

import com.epam.medicines.entity.Analogs;
import com.epam.medicines.entity.Medicine;
import com.epam.medicines.parser.MedicineEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;
import java.util.stream.Collectors;

public class MedicineSaxHandler extends DefaultHandler {

    private LinkedList<Medicine> medicines;

    private Medicine current = new Medicine();

    private MedicineEnum currentEnum;

    private EnumSet<MedicineEnum> withText;

    private static final String ELEMENT_MEDICINE = "medicine";
    private static final String ELEMENT_VERSION = "version";

    public MedicineSaxHandler() {
        medicines = new LinkedList<>();
        withText = EnumSet.range(MedicineEnum.NUMBER, MedicineEnum.DOSAGE_PERIOD);
    }

    public LinkedList<Medicine> getMedicines() {
        return medicines;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ELEMENT_MEDICINE.equals(qName)) {
            current = new Medicine();
            current.setName(attributes.getValue(0));
            if (attributes.getLength() == 2) {
                current.setPharm(attributes.getValue(1));
            }
        } else if (ELEMENT_VERSION.equals(qName)) {
            current.getVersion().setVersion_type(attributes.getValue(0));
        } else {
            MedicineEnum temp = MedicineEnum.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (ELEMENT_MEDICINE.equals(qName)) {
            medicines.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).strip();
        if (currentEnum != null) {
            switch (currentEnum) {
                case GROUP:
                    current.setGroup(data);
                    break;
                case ANALOGS:
                    String[] dataArray = data.split(",");
                    List<String> datacollect = Arrays.stream(dataArray).collect(Collectors.toList());
                    List<Analogs> analogs = datacollect.stream()
                            .map(analog -> new Analogs(analog))
                            .collect(Collectors.toList());
                    current.setAnalogsList(analogs);
                    break;
                case NUMBER:
                    current.getVersion().getCertificate().setNumber(data);
                    break;
                case DATE_OF_ISSUE:
                    current.getVersion().getCertificate().setDateOfIssue(data);
                    break;
                case EXPIRATION:
                    current.getVersion().getCertificate().setExpiration(data);
                    break;
                case ORGANIZATION:
                    current.getVersion().getCertificate().setOrganization(data);
                    break;
                case PACKAGE_TYPE:
                    current.getVersion().getMedicinePackage().setType(data);
                    break;
                case PACKAGE_AMOUNT:
                    current.getVersion().getMedicinePackage().setAmount(Integer.parseInt(data));
                    break;
                case PACKAGE_PRICE:
                    current.getVersion().getMedicinePackage().setPrice(Integer.parseInt(data));
                    break;
                case DOSAGE_AMOUNT:
                    current.getVersion().getDosage().setAmount(Integer.parseInt(data));
                    break;
                case DOSAGE_PERIOD:
                    current.getVersion().getDosage().setPeriod(data);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
