package com.epam.medicines.main;

import com.epam.medicines.parser.stax.MedicineStaxBuilder;

public class MainStax {
    public static void main(String[] args) {
        MedicineStaxBuilder staxBuilder=new MedicineStaxBuilder();
        staxBuilder.buildListMedicines("data\\medicines.xml");
        System.out.println(staxBuilder.getMedicines());
    }
}
