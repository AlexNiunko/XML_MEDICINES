package com.epam.medicines.validator;

import org.apache.log4j.FileAppender;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

public class MedicineErrorHandler extends DefaultHandler {
    private Logger logger = Logger.getLogger("com.epam.niunko");

    public MedicineErrorHandler(String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public MedicineErrorHandler() {
    }

    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + e.getMessage());
    }

    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
