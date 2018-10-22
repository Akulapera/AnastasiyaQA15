package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!app.isGContactPresent()){
            app.createContact();
        }
    }
    @Test
    public void testContactModification(){
        app.selectContactForModify();
        app.fillContactForm(new Contact()
                .setNameLastName("Kuznet")
                .setNameEmail("iuui@com")
                .setNameFirstName("Vita")
                .setNameAddress("Lvov")
                .setNameTelephone("0675554433"));
        app.updateContact();
    }

}

