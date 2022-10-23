package com.epam.medicines.parser.sax;

public enum MedicineEnum {
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARM("pharm"),
    VERSION("version"),
    VERSION_TYPE("versionType"),
    CERTIFICATE("certificate"),
    MEDICINE_PACKAGE("medicinePackage"),
    MEDICINE_DOSAGE("medicineDosage"),

    NUMBER("number"),
    GROUP("group"),
    ANALOGS("analogs"),
    DATE_OF_ISSUE("dateOfIssue"),
    EXPIRATION("expiration"),
    ORGANIZATION("organization"),
    PACKAGE_TYPE("packageType"),
    PACKAGE_AMOUNT("packageAmount"),
    PACKAGE_PRICE("packagePrice"),
    DOSAGE_AMOUNT("dosageAmount"),
    DOSAGE_PERIOD("dosagePeriod");

    private String value;

    MedicineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
