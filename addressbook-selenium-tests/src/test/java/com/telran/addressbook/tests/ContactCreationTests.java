package com.telran.addressbook.tests;

import com.telran.addressbook.model.Contact;
import com.telran.addressbook.model.Group;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new Contact()
                    .setNameLastName(split[0])
                    .setNameEmail(split[1])
                    .setNameFirstName(split[2])
                    .setNameTelephone(split[3])
                    .setNameAddress(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test (dataProvider="validContacts")
    public void testContactCreation(Contact contact) {
        app.getContactHelper().openContactPage();
        app.getContactHelper().fillContactForm(contact);
        //(new Contact()
//                .setNameLastName("Max")
//                .setNameEmail("ouy@com")
//                .setNameFirstName("Ivaniv")
//                .setNameTelephone("415436")
//                .setNameAddress("Tel Aviv"));
        app.getContactHelper().submitContactCreation();
    }
}
