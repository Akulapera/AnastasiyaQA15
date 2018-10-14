package com.tel.ran.qa15.sandbox.homework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromOpenWiki {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
    }

    @Test
    public void testOpenWikiInChrome() {
        wd.navigate().to("https://ru.wikipedia.org");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

}