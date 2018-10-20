package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() {
        openContactPage();
        fillContactForm(new Contact()
                .setNameLastName("Max")
                .setNameEmail("ouy@com")
                .setNameFirstName("Ivaniv")
                .setNameTelephone("415436")
                .setNameAddress("Tel Aviv"));
        submitContactCreation();
    }

}
