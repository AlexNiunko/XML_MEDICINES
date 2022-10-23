package com.epam.medicines.main;

import com.epam.medicines.entity.Medicine;
import com.epam.medicines.parser.sax.MedicineSaxBuilder;

import java.io.IOException;

public class MainSax {
    public static void main(String[] args) throws IOException {
        MedicineSaxBuilder saxBuilder=new MedicineSaxBuilder();
        saxBuilder.buildSetMedicine("data\\medicines.xml");
        System.out.println(saxBuilder.getMedicines());

    }
}
