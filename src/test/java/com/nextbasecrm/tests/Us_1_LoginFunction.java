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

public class Us_1_LoginFunction {
    WebDriver driver;
    //Setting up the beforeMethod for every test case!
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");
    }
    // Test case 1 : The login page title should be “Authorization.”
    @Test
    public void TestCase1(){

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"actual title is not Authorization");

    }
    // Test case 2: The user should go to the homepage after login in successfully.
    @Test
    public void TestCase2(){
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys("hr31@cybertekschool.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        // To check the driver able to get homepage after login in successfully.
        Assert.assertTrue(driver.getTitle().contains("Portal"));
    }


    //Test case 3: “Incorrect username or password” should be displayed when a user enters the wrong username or password.
    @Test
    public void TestCase3(){
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys("WRONGUSERNAME@cybertekschool.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("WRONGPASSWORD");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement incorrectUsernameOrPassword = driver.findElement(By.xpath("//div[@class='errortext']"));

        //to check the text -“Incorrect username or password”- is displayed.
        Assert.assertTrue(incorrectUsernameOrPassword.isDisplayed());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }


}
