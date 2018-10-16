package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupDelete extends TestBase {
@Test
    public void testGroupDeletion(){
    openGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
}

}
