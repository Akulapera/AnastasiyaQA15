package com.tel.ran.qa15.sandbox.homework2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenWikiAndSearchJava extends TestBase{

    @Test
    public void openSiteTest() {

        enterToWiki();

        writeJavaInFild();

        pressButton();
    }

}
