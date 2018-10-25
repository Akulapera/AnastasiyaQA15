package com.telran.addressbook.tests;

import com.telran.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public  void preconditions () {
        app.getGroupHelper().openGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createCroup();
        }
    }


    @Test
    public void testGroupModification(){
        app.getGroupHelper().openGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("QQQQ")
                .setGroupHeader("YYYY")
                .setGroupFooter("RRRR"));
        app.submitModification();
        app.getGroupHelper().returnToGroupPage();
        int after= app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before);
    }

}
