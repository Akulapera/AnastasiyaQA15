package com.tel.ran.qa15.sandbox.homework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EdgeOpenWiki {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd= new EdgeDriver();
    }

    @Test
    public  void testOpenWikiInEdge() {
        wd.navigate().to("https://ru.wikipedia.org");
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }


}
