package com.telran.addressbook.tests;

import com.telran.addressbook.model.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!app.getContactHelper().isGContactPresent()){
            app.getContactHelper().createContact();
        }
    }
    @Test(enabled = false)
    public void testContactModification(){
        app.getContactHelper().selectContactForModify();
        app.getContactHelper().fillContactForm(new Contact()
                .setNameLastName("Kuznet")
                .setNameEmail("iuui@com")
                .setNameFirstName("Vita")
                .setNameAddress("Lvov")
                .setNameTelephone("0675554433"));
        app.getContactHelper().updateContact();
    }

}

