package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!isGContactPresent()){
           createContact();
        }
    }

    @Test
     public void ContactDelete(){
        selectContact();
        deleteContact();
    }
}
