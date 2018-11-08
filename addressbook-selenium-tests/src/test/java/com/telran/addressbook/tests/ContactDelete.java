package com.telran.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDelete extends TestBase {
    @BeforeMethod
    public void preconditions()
    {
        if(!app.getContactHelper().isGContactPresent()){
           app.getContactHelper().createContact();
        }
    }

    @Test
     public void ContactDelete(){
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
       // try {
        ////    Thread.sleep(3000);
       /// } catch (InterruptedException e) {
         //   e.printStackTrace();
        }
       // app.getContactHelper().alertNameDeletion();
    //}
}
