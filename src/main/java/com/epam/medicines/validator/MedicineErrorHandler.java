package com.epam.medicines.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.apache.log4j.FileAppender;

import java.io.IOException;

public class MedicineErrorHandler implements ErrorHandler {
    private Logger logger = LogManager.getLogger("com.epam.niunko");


    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.warn(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.error(getLineColumnNumber(exception) + " - " + exception.getMessage());

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.fatal(getLineColumnNumber(exception) + " - " + exception.getMessage());

    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
