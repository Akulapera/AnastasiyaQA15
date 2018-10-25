package com.telran.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!app.isGContactPresent()){
           app.createContact();
        }
    }

    @Test
     public void ContactDelete(){
        app.selectContact();
        app.deleteContact();
    }
}
