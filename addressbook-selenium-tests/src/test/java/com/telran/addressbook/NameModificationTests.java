package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NameModificationTests extends TestBase {
    @Test
    public void testNameModification(){
        selectNameForModify();
        fillNameForm("Olya", "Kisel", "Zagreb", "8888", "gfg@gmail.com");
        updateName();
    }

}
