package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Jewel_US10 {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }

    @Test
    public void createTask() throws InterruptedException {

        WebElement InputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
       // InputUserName.sendKeys("hr31@cydeo.com"); // passed
       // InputUserName.sendKeys("helpdesk31@cybertekschool.com"); //passed
        InputUserName.sendKeys("marketing33@cybertekschool.com"); //no popup for task creation

        WebElement InputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        InputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

    }

}

