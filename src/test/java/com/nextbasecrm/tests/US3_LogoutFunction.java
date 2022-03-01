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

public class US3_LogoutFunction {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void logoutFunctionTest() throws InterruptedException {

        //1. Go to:https://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com");

        //2.Enter a valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cybertekschool.com");
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //3.Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //4.Click to the Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        Thread.sleep(1000);


        //5. Users click user profile name on the right top corner.
        WebElement profileName = driver.findElement(By.xpath("//span[@id='user-name']"));
        profileName.click();

        Thread.sleep(1000);

        //6.Users click “Log Out” option.
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutButton.click();


        //7. Verify the users back to the log in page.
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}



