package com.telran.addressbook.tests;

import com.telran.addressbook.model.Contact;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
        app.getContactHelper().openContactPage();
        app.getContactHelper().fillContactForm(new Contact()
                .setNameLastName("Max")
                .setNameEmail("ouy@com")
                .setNameFirstName("Ivaniv")
                .setNameTelephone("415436")
                .setNameAddress("Tel Aviv"));
        app.getContactHelper().submitContactCreation();
    }

}
