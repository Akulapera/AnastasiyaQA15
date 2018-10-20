package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!isGContactPresent()){
            createContact();
        }
    }
    @Test
    public void testContactModification(){
        selectContactForModify();
        fillContactForm(new Contact()
                .setNameLastName("Kuznet")
                .setNameEmail("iuui@com")
                .setNameFirstName("Vita")
                .setNameAddress("Lvov")
                .setNameTelephone("0675554433"));
        updateContact();
    }

}

