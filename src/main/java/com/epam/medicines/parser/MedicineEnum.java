package com.epam.medicines.parser;

public enum MedicineEnum {
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARM("pharm"),
    VERSION("version"),
    VERSION_TYPE("version_type"),
    CERTIFICATE("certificate"),
    MEDICINE_PACKAGE("medicine_package"),
    MEDICINE_DOSAGE("medicine_dosage"),

    NUMBER("number"),
    GROUP("group"),
    ANALOGS("analogs"),
    DATE_OF_ISSUE("date_of_issue"),
    EXPIRATION("expiration"),
    ORGANIZATION("organization"),
    PACKAGE_TYPE("package_type"),
    PACKAGE_AMOUNT("package_amount"),
    PACKAGE_PRICE("package_price"),
    DOSAGE_AMOUNT("dosage_amount"),
    DOSAGE_PERIOD("dosage_period");

    private String value;

    MedicineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
