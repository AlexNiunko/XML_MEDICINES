package com.epam.medicines.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    public static void main(String[] args) {
        String filename="data\\medicines.xml";
        String schemaname="data\\medicines.xsd";
        String logname="logs\\log.txt";
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaname);
        try{
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(filename);
            validator.setErrorHandler(new MedicineErrorHandler());
            validator.validate(source);
        } catch (SAXException  | IOException e) {
            System.err.println(filename+"is not correct valid");
        }
    }
}
