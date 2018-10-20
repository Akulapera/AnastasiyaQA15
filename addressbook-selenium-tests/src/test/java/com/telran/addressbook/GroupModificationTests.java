package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public  void preconditions () {
        openGroupsPage();
        if (!isGroupPresent()) {
            createCroup();
        }
    }


    @Test
    public void testGroupModification(){
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group()
                .setGroupName("QQQQ")
                .setGroupHeader("YYYY")
                .setGroupFooter("RRRR"));
        submitModification();
        returnToGroupPage();
    }
}
