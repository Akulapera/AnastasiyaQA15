package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
     @BeforeMethod
     public  void preconditions () {
         app.getGroupHelper().openGroupsPage();
         if (!app.getGroupHelper().isGroupPresent()) {
             app.getGroupHelper().createCroup();
         }
     }


    @Test
    public void testGroupDeletion() throws InterruptedException {
    app.getGroupHelper().openGroupsPage();
    Thread.sleep(4000);
    int before= app.getGroupHelper().getGroupsCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    int after= app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after, before-1);
}

}
