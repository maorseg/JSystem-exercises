package com.aqua.services.junit4;

import java.io.IOException;
import java.net.URL;
// import org.junit.Test;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

// Winium example -> http://seleniumocean.blogspot.co.il/2016/06/winium-for-automating-desktop.html

public class Winium  {

   /* public static void main(String[] args) throws IOException {
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Appium Jars and Drivers\\Winium\\Winium.Desktop.Driver.exe");
        p.start();
    }*/
   @Test
    public void Calc() throws InterruptedException, IOException {

       DesktopOptions options = new DesktopOptions();
       options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
       try {
           WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
           driver.findElementByName("שמונה").click();
           driver.findElementByName("ועוד").click();
           driver.findElementByName("שמונה").click();
           driver.findElementByName("שווה").click();
           // Using wait command so that result can be noticed (5 seconds wait)
           SECONDS.sleep(5);
           driver.findElementByName("Close מחשבון").click();

           //driver.findElementByClassName("Edit").sendKeys("This is sample test");
           driver.close();
           driver.quit();

       } catch (Exception e) {

           System.out.println(e.getMessage());
       }
   }
}
