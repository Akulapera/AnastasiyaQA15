package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests  extends TestBase{

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupFooter("ttt")
                .setGroupHeader("iiii")
                .setGroupName("uuuu"));
        submitGroupCreation();
        returnToGroupPage();
    }
}
