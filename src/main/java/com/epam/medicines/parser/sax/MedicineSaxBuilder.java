package com.epam.medicines.parser.sax;

import com.epam.medicines.entity.Medicine;
import com.epam.medicines.validator.MedicineErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MedicineSaxBuilder {
    static final Logger logger = LogManager.getLogger();
    private List<Medicine> medicines;
    private MedicineSaxHandler sh=new MedicineSaxHandler();
    private XMLReader reader;

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public MedicineSaxBuilder(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public MedicineSaxBuilder() throws IOException {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser= factory.newSAXParser();
            reader= saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.log(Level.ERROR, "SAX parser error");
        }
        reader.setErrorHandler(new MedicineErrorHandler());
        reader.setContentHandler(sh);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicine(String fileName) {
        try {
            reader.parse(fileName);
            medicines= sh.getMedicines();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
