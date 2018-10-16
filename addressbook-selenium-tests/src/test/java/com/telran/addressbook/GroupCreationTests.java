package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests  extends TestBase{

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm("name test1", "header", "footer");
        submitGroupCreation();
        returnToGroupPage();
    }
}
