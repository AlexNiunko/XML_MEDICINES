package com.epam.medicines.main;

import com.epam.medicines.parser.dom.MedicineDomBuilder;

public class MainDom {
    public static void main(String[] args) {
        MedicineDomBuilder domBuilder=new MedicineDomBuilder();
        domBuilder.buildListMedicines("data\\medicines.xml");
        System.out.println(domBuilder.getMedicines());

    }
}
