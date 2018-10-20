package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
     @BeforeMethod
     public  void preconditions () {
         openGroupsPage();
         if (!isGroupPresent()) {
             createCroup();
         }
     }


    @Test
    public void testGroupDeletion(){
    openGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
}

}
