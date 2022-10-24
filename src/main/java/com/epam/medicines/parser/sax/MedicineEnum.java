package com.epam.medicines.parser.sax;

public enum MedicineEnum {
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARM("pharm"),
    VERSION("version"),
    VERSIONTYPE("versionType"),
    CERTIFICATE("certificate"),
    MEDICINEPACKAGE("medicinePackage"),
    MEDICINEDOSAGE("medicineDosage"),

    NUMBER("number"),
    GROUP("group"),
    ANALOGS("analogs"),
    DATEOFISSUE("dateOfIssue"),
    EXPIRATION("expiration"),
    ORGANIZATION("organization"),
    PACKAGETYPE("packageType"),
    PACKAGEAMOUNT("packageAmount"),
    PACKAGEPRICE("packagePrice"),
    DOSAGEAMOUNT("dosageAmount"),
    DOSAGEPERIOD("dosagePeriod");

    private String value;

    MedicineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
