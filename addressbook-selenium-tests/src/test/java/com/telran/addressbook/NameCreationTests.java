package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NameCreationTests extends TestBase {
    @Test
    public void testNameCreation() {
        openNamePage();
        fillNameForm("Marina", "Second", "Rovno", "495786", "gfg@afaf");
        submitNameCreation();
    }

}