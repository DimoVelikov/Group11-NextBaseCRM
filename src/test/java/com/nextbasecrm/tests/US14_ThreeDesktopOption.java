package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US14_ThreeDesktopOption {



    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void desktopOptionTest() {


        //1. Go to:https://login2.nextbasecrm.com
        driver.get("https://login2.nextbasecrm.com");

        //2.Enter a valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("marketing33@cydeo.com");
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //3.Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //4.Click to the Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //Mac os
        WebElement macOs = driver.findElement(By.xpath("//span[.='Mac OS']"));
        String actualMacText = macOs.getText();
        String expectedMacText = "MAC OS";

        //windows
        WebElement windows = driver.findElement(By.xpath("//span[.='Windows']"));
        String actualWindowsText = windows.getText();
        String expectedWindowsText = "WINDOWS";


        //linux
        WebElement linux = driver.findElement(By.xpath("//span[.='Linux']"));
        String actualLinuxText = linux.getText();
        String expectedLinuxText = "LINUX";


        Assert.assertEquals(expectedMacText, actualMacText);
        Assert.assertEquals(expectedWindowsText, actualWindowsText);
        Assert.assertEquals(expectedLinuxText, actualLinuxText);

    }


    @AfterMethod
    public void tearDown(){
        driver.close();

    }


}











