package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NameDelete extends TestBase {
    @Test
     public void nameDelete(){
        selectName();
        deleteName();
    }
}
