package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static java.util.concurrent.TimeUnit.SECONDS;


public class LaunchingChrome extends SystemTestCase4 {

    @Test
    public void setUp() throws Exception {

        // chromedriver server path
        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        // Instantiate a ChromeDriver class
        WebDriver driver = new ChromeDriver();

        // Sets the amount of time to wait for a page load to complete before throwing an error
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);

        // Storing the Application Url in the String variable
        String url = "https://www.youtube.com/";

        //Launch the demoqa WebSite
        driver.get(url);

        // Storing Title name in the String variable
        String title = driver.getTitle();

        // Printing Title & Title length in the Console window
        System.out.println("Title of the page is : " + title);

        // Storing URL in String variable
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(url)){
            System.out.println("Verification Successful - The correct Url is opened.");
        } else{
            System.out.println("Verification Failed - An incorrect Url is opened.");

            //In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }

        // Load another URL i.e facebook
        driver.navigate().to("http://www.facebook.com");

        // Type Name in the FirstName text box
        driver.findElement(By.name("firstname")).sendKeys("Maor");
        //Type LastName in the LastName text box
        driver.findElement(By.name("lastname")).sendKeys("Segev");

        // select month
        Select oSelect = new Select(driver.findElement(By.id("month")));
        oSelect.selectByVisibleText("Nov");

        // select day
        Select oSelect1 = new Select(driver.findElement(By.id("day")));
        oSelect1.selectByVisibleText("19");

        // select year
        Select oSelect2 = new Select(driver.findElement(By.id("year")));
        oSelect2.selectByVisibleText("2010");

        // To get the Count of the total elements inside SELECT year and to Print the text value of every element present in the SELECT.
        Select oSelect3 = new Select(driver.findElement(By.id("year")));
        List <WebElement> elementCount = oSelect3.getOptions();
        int iSize = elementCount.size();

        for(int i =0; i< iSize ; i++){
            String sValue = elementCount.get(i).getText();
            System.out.println(sValue);
        }

        // Using wait command so that changes can be noticed (5 seconds wait)
        SECONDS.sleep(5);

        // Go back to first Page i.e. youtube
        driver.navigate().back();

        // refresh the browser
        driver.navigate().refresh();

        // Than Close the browser
        driver.close();
    }

}
