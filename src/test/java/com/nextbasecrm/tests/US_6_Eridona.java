package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US_6_Eridona {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {

        //Description:  Users create tasks successfully
        //Environment:  https://login2.nextbasecrm.com/
        //Steps:: Users are on the homepage
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }


    @Test
    public void taskMore(){
        WebElement loginBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginBox.clear();
        loginBox.sendKeys("hr37@cydeo.com");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.clear();
        passwordBox.sendKeys("UserUser");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        WebElement moreButton= driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();

    }
}

