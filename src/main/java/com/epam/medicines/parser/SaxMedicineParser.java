package com.epam.medicines.parser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SaxMedicineParser {
    private static final String path="data\\medicines.xml";
    public static void main(String[] args) {

        try {
            XMLReader reader= XMLReaderFactory.createXMLReader();
            ConsoleMedicineHandler handler=new ConsoleMedicineHandler();
            reader.setContentHandler(handler);
            reader.parse(path);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
