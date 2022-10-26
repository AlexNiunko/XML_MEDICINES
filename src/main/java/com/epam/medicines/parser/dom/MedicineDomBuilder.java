package com.epam.medicines.parser.dom;

import com.epam.medicines.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedicineDomBuilder {
    static final Logger logger = LogManager.getLogger();
    private List<Medicine> medicines;
    private DocumentBuilder docBuilder;

    public MedicineDomBuilder(){
        medicines=new ArrayList<>();
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try{
            docBuilder= factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR,"Parser configuration error"+e);
        }
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
    public void buildListMedicines(String filename){
        try{
            Document doc=docBuilder.parse(filename);
            Element root=doc.getDocumentElement();
            NodeList medicineList= root.getElementsByTagName("medicine");
            for (int i = 0; i < medicineList.getLength(); i++) {
                Element medicineElement=(Element) medicineList.item(i);
                Medicine medicine=buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (IOException | SAXException e ) {
            logger.log(Level.ERROR,"Parser configuration error"+e);

        }
    }
    private Medicine buildMedicine(Element medicineElement){
        Medicine medicine=new Medicine();
        medicine.setName(medicineElement.getAttribute("name").toLowerCase());
        medicine.setPharm(medicineElement.getAttribute("pharm").toLowerCase());
        medicine.setGroup(medicineElement.getElementsByTagName("group").item(0).getTextContent());
        medicine.setAnalogsList(listAnalogs(medicineElement));
        Version version=medicine.getVersion();
        Element versionElement=(Element)medicineElement.getElementsByTagName("version").item(0);
        version.setVersion_type(versionElement.getAttribute("version_type").toLowerCase());
        Certificate certificate= version.getCertificate();
        Element certificateElement=(Element)versionElement.getElementsByTagName("certificate").item(0);
        certificate.setNumber(certificateElement.getElementsByTagName("number").item(0).getTextContent());
        certificate.setDateOfIssue(certificateElement.getElementsByTagName("date_of_issue").item(0).getTextContent());
        certificate.setExpiration(certificateElement.getElementsByTagName("expiration").item(0).getTextContent());
        certificate.setOrganization(certificateElement.getElementsByTagName("organization").item(0).getTextContent());
        MedicinePackage medicinePackage= version.getMedicinePackage();
        Element medicinePackageElement=(Element)versionElement.getElementsByTagName("medicine_package").item(0);
        medicinePackage.setType(medicinePackageElement.getElementsByTagName("package_type").item(0).getTextContent());
        medicinePackage.setAmount(Integer.parseInt(medicinePackageElement.getElementsByTagName("package_amount").item(0).getTextContent()));
        medicinePackage.setPrice(Integer.parseInt(medicinePackageElement.getElementsByTagName("package_price").item(0).getTextContent()));
        Dosage dosage= version.getDosage();
        Element medicineDosageElement=(Element)versionElement.getElementsByTagName("medicine_dosage").item(0);
        dosage.setAmount(Integer.parseInt(medicineDosageElement.getElementsByTagName("dosage_amount").item(0).getTextContent()));
        dosage.setPeriod(medicineDosageElement.getElementsByTagName("dosage_period").item(0).getTextContent());
        return medicine;
    }
    private static String getElementTextContent(Element element,String elementName){
        NodeList nlist=element.getElementsByTagName(elementName);
        Node node=nlist.item(0);
        String text=node.getTextContent();
        return text;
    }



    private List<Analogs>listAnalogs(Element medicineElement){
          String[] dataArray = medicineElement.getElementsByTagName("analogs").item(0).getTextContent().split(",");
          List<String> datacollect = Arrays.stream(dataArray).collect(Collectors.toList());
          List<Analogs> analogs = datacollect.stream()
                .map(analog -> new Analogs(analog))
                .collect(Collectors.toList());
        return analogs;
    }

}

