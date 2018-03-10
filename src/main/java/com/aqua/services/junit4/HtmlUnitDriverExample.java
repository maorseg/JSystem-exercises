package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverExample extends SystemTestCase4 {

    HtmlUnitDriver driver;
    String pagetitle;

    @Before
    public void setup() throws Exception {
        //Initializing HtmlUnitDriver
        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Opening URL In HtmlUnitDriver
        driver.get("https://www.facebook.com/");


    }

    @Test
    public void facebooklogin() {

        //Get and print page title before login
        pagetitle = driver.getTitle();
        report.report("Page title : " + pagetitle);

        // Login to facebook
        driver.findElement(By.name("email")).sendKeys("maorseg@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("verticalcrossbow1");
        WebElement textbox = driver.findElement(By.name("pass"));
        textbox.sendKeys(Keys.ENTER);

        //Get and print page title after login
        pagetitle = driver.getTitle();
        report.report("Page title : " + pagetitle);

    }

        @After
        public void tearDown() throws Exception {
            //Closing HtmlUnitDriver
            driver.quit();
        }
}